<style scoped>
	.login{
	height: 350px;
    width: 460px;
    top: 100px;
    position: relative;
	border-radius: 30px;
    text-align: center;
	
	background: rgba(0,50,100,0.8);
	margin: auto;
	}
	#login_div{
		height: 100%;background-image: url(/ex/image/bj.jpg);background-size: 100% 100%;
	}
	.ivu-radio-group{
		color: white;
	}
</style>
<template>
	<div id="login_div">
		<div style="height: 6%;"></div>
		<div class="login">
			<br />
			<br />
			<h1 style="color: white;">快递运输平台中心</h1>
			<br />
			<Form style="width: 330px;margin: auto;">
				<div>
					<FormItem>
						<Input type="text" v-model="phone" maxlength=11 placeholder="手机号">
						<Icon type="md-phone-portrait" slot="prepend"></Icon>
						</Input>
					</FormItem>
					<FormItem>
						<Input type="password" v-model="password" maxlength=16 placeholder="密码">
						<Icon type="ios-lock-outline" slot="prepend"></Icon>
						</Input>
					</FormItem>
					<FormItem>
						<Input v-model="yzm" style="width: 150px;" maxlength=7 placeholder="验证码">
						<Icon type="ios-keypad-outline" slot="prepend" />
						</Input>
						<div style="letter-spacing:8px;width: 150px;position: absolute;background-color: rgb(152, 165, 152);top:-10px;left: 170px;line-height: 48px;font-size: 24px;">
							{{yzms}}
						</div>
					</FormItem>
				</div>
				<FormItem>
					<a @click="handleSubmit()">
						<Button type="success" onclick="return false" long> 登 录 </Button>
					</a>
					<a @click="zc()">没有账号?注册</a>
				</FormItem>
			</Form>
		</div>
		<div style="height:6%;"></div>
	</div>
</template>
<script>
	export default {
		data() {
			return {
				password: '',
				phone: '',
				yzm:'',
				yzms:'',
				code: 1024
			}
		},
		methods: {
			handleSubmit() {
				if (this.phone.length == 0 || this.phone.trim() == "") {
					this.$Message.warning('请输入用户名!');
					return false;
				}
				if (this.password.length == 0 || this.password.trim() == "") {
					this.$Message.warning('请输入密码!');
					return false;
				}
				if (this.yzm.length == 0 || this.yzm.trim() == "") {
					this.$Message.warning('请输入验证码!');
					return false;
				}
				if (this.yzm.length != this.yzms.length || this.yzm != this.yzms) {
					this.$Message.warning('验证码不正确!');
					this.setyzm();
					return false;
				}
				var th = this;
				axios.get('/ex/personnelInfo/doLogin', {
					params: {
						phone: th.phone,
						password: th.password
					}
				}).then(function(res) {
					th.bd(res);
				});
				return false;
			},
			zc() {
				window.location.href = "/#/register";
			},
			reads(){
				return Math.ceil( (Math.random() * 9)).toString();
			},
			bd(res) {
				if (res.data.code == 200) {
					localStorage.setItem('User', JSON.stringify(res.data.data));
					var user = localStorage.getItem('User');
					console.log(JSON.parse(user));
					this.$Message.success("登录成功,正在调转页面...");
					setTimeout(function() {
						window.location.href = "/#/index";
					}, 900);
				} else {
					this.password = "";
					this.setyzm();
					this.$Message.error(res.data.message);
				}
			},
			setyzm(){
				this.yzms = this.reads() + this.reads()+this.reads()+this.reads()+this.reads()+this.reads();
				this.yzm = "";
			}
		},created() {
			this.setyzm();
		}
	}
</script>
