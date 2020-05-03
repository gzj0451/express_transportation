<style scoped>
	.login{
	height: 500px;
	width: 580px;
	top: 30px;
	position: relative;
	border-radius: 30px;
	text-align: center;
	background:rgba(86, 75, 75, 0.65);
	margin: auto;
	}
	.ivu-form-item{
		margin:0;
	}
	#login_div{
		height: 100%;
		background-image: url(/ex/image/bj.jpg);
		background-size: 100% 100%;
	}
</style>
<template>
	<div id="login_div">
		<div style="height: 6%;"></div>
		<div class="login">
			<br />
			
			<h1 style="color: white;">快递运输注册中心</h1><br />
			<Form ref="formValidate" style="width: 450px;margin: auto;" :model="personnelInfo" class="personnelInfo">
					<FormItem label="性别" prop="sex">
						<RadioGroup v-model="personnelInfo.sex">
							<Radio label="男"></Radio>
							<Radio label="女"></Radio>
						</RadioGroup>
					</FormItem>
					<FormItem label="姓名" prop="pName">
						<Input v-model="personnelInfo.pName" :maxlength=6 placeholder="请输入姓名"></Input>
					</FormItem>
					<FormItem label="出生日期" prop="birthhday">
						<DatePicker type="date" placeholder="Select date" style="width: 100%" v-model="personnelInfo.birthhday"></DatePicker>
					</FormItem>
					<FormItem label="手机号码" prop="phone">
						<Input v-model="personnelInfo.phone" :maxlength=11 placeholder="请输入手机号码"></Input>
					</FormItem>
					<FormItem label="密码" prop="password">
						<Input type="password" v-model="personnelInfo.password" :maxlength=16 placeholder="请输入密码"></Input>
					</FormItem>
				<br />
				<FormItem>
					<a @click="handleSubmit()">
						<Button type="success" onclick="return false" long> 快    速     注    册 </Button>
					</a>
					<a @click="login()"> 已 有 账 号 ? 快 速 登 录</a>
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
				personnelInfo: {
					pId: 0,
					pName: '',
					sex: '男',
					birthhday: '',
					password: '',
					role: '客户',
					phone: ''
				},
			}
		},
		methods: {
			//添加保存
			handleSubmit() {
				if (this.personnelInfo.pName.length < 1) {
					this.$Message.warning('请输入名字!');
					
					return;
				}
				if (this.personnelInfo.phone.length < 1 || this.personnelInfo.phone.length != 11) {
					this.$Message.warning('电话号码不正确，需要11位手机号码!');
					
					return;
				}
				if (this.personnelInfo.password.length < 6 ) {
					this.$Message.warning('密码不正确,需要6位以上!');
					return;
				}
				const th = this;
				axios.post('/ex/personnelInfo/insert', th.personnelInfo, {
					headers: {
						"Content-Type": "application/json;charset=utf-8"
					}
				}).then(function(res) {
					if (res.data.code === 200) {
						th.$Message.success("注册成功！");
						setTimeout(function() {
							window.location.href = "/";
						}, 900);
					} else {
						if (res.data.message.indexOf("for key") > 0) {
							th.$Message.error("手机号码重复");
						} else {
							th.$Message.error("注册失败！请重试");
						}
					}
				})
				return false;
			},
			login(){
				window.location.href = "/";
			}

		}
	}
</script>
