<style>
	.rigtop { width: 100%; left: 20; height: 45px;border: 1px solid #dcdee2;padding: 5px;line-height: 45px;margin:5px 0;}
	.rigtop form{
		height: 35px;
	}
	.rigtop .ivu-select-selection,.ivu-select-input, .rigtop .ivu-input{
		height: 28px;
	}
	.rigtop .ivu-btn {
		padding: 4px 5px 4px;
	}
</style>
<style scoped>
	.ivu-layout-header{
		z-index: 999;
}
.ivu-menu-horizontal,.layout-logo,.ivu-layout-header{
	height: 50px;
	line-height:50px; 
	top:0px;
}
.ivu-menu-vertical{
	height: 607px;
}
.layout{
    background: #f5f7f9;
    position: relative;
    overflow: hidden;
}
.layout-logo{
    width: 100px;
    float: left;
    position: relative;
    top: 15px;
    left: 20px;
}
.layout-nav{
   right: 50px;
    position: absolute;
}
</style>
<template>
	<div class="layout">
		<Layout>
			<!--头部-->
			<Header>
				<Menu mode="horizontal" :theme="theme" active-name="6" :style="{position: 'fixed', width: '100%'}">
					<div class="layout-logo" style="left:-50px;top:0px;width:50%;text-align: center; ">
						<Menu mode="horizontal" @on-select="topfu" :accordion="true" :theme="theme" active-name="1">
							<div class="layout-logo" style="left:0;top:0;width: 200px;;text-align: center;padding-left: 6px;">
								<router-Link to="/index/">
									<MenuItem name="控制台">
									<h3>快递运输平台</h3>
									</MenuItem>
								</router-Link>
							</div>
							<router-Link to="/index">
								<MenuItem name="控制台">
								<Icon type="ios-paper" />
								控制台
								</MenuItem>
							</router-Link>
						</Menu>
					</div>
					<div class="layout-nav">
						<MenuItem name="5">
						<Avatar src="https://i.loli.net/2017/08/21/599a521472424.jpg" />
						<Dropdown>
							{{info.pName}}
							<Icon type="ios-arrow-down"></Icon>
							<DropdownMenu slot="list">
								<DropdownItem @click.native="updatepassword">修改密码</DropdownItem>
							</DropdownMenu>
						</Dropdown>
						<Modal v-model="modal13" draggable scrollable title="修改密码" @on-ok="ok">
							<Form ref="formValidate" :model="user" :label-width="80">
								<FormItem label="旧密码" prop="password">
									<Input type="password" v-model="user.password" maxlength=16 placeholder="请输入旧密码"></Input>
								</FormItem>
								<FormItem label="新密码" prop="passwords">
									<Input type="password" v-model="user.passwords" maxlength=16 placeholder="请输入新密码"></Input>
								</FormItem>
								<FormItem label="确认密码" prop="passwordss">
									<Input type="password" v-model="user.passwordss" maxlength=16 placeholder="请输入确认密码"></Input>
								</FormItem>
							</Form>
						</Modal>
						</MenuItem>
						<Submenu name="6">
							<template slot="title">
								<Icon type="ios-shirt-outline" />
								更换主题
							</template>
							<div style="background-color: #1b315e">
								<RadioGroup v-model="theme">
									<Radio label="dark">
										<Icon type="social-apple"></Icon>
										<span>黑色主题</span>
									</Radio>
									<Radio label="light">
										<Icon type="social-android"></Icon>
										<span>白色主题</span>
									</Radio>
									<Radio label="primary">
										<Icon type="social-windows"></Icon>
										<span>飘色主题</span>
									</Radio>
								</RadioGroup>
							</div>

						</Submenu>
						<MenuItem name="3" @click.native="logout">
						<Icon type="ios-exit-outline" />
						<span>退出</span>
						</MenuItem>
					</div>

				</Menu>
			</Header>
			<Layout>
				<!--左边-->
				<Sider hide-trigger :style="{background: '#fff'}">
					<Menu @on-open-change="fu" @on-select="ze" :accordion="true" active-name="1-2" :theme="theme" width="auto"
					 :open-names="['1']">
							<Submenu name="订单管理">
								<template slot="title">
									<Icon type="logo-yen" />
									订单管理
								</template>
								<router-Link to="/waybillall">
									<MenuItem name="订单信息查询">订单信息查询</MenuItem>
								</router-Link>
								<div v-if="role != '快递员'">
								<router-Link to="/waybilladd">
									<MenuItem name="快速下单">快速下单</MenuItem>
								</router-Link>
								</div>
							</Submenu>
							<Submenu name="位置管理">
								<template slot="title">
									<Icon type="md-done-all"></Icon>
									位置管理
								</template>
								<router-Link to="/personnelInfoall">
									<MenuItem name="订单位置查询">订单位置查询</MenuItem>
								</router-Link>
								<div v-if="role != '客户' ">
								<router-Link to="/personnelInfoadd">
									<MenuItem name="订单位置录入">订单位置录入</MenuItem>
								</router-Link>
								</div>
							</Submenu>
						<div v-if="role == '管理员'">
							<Submenu name="评价管理">
								<template slot="title">
									<Icon type="ios-ribbon" />
									评价管理
								</template>
								<router-Link to="/evaluateall">
									<MenuItem name="评价信息">评价信息</MenuItem>
								</router-Link>
							</Submenu>
							<Submenu name="系统管理">
								<template slot="title">
									<Icon type="ios-people"></Icon>
									系统管理
								</template>
								<router-Link to="khInfo">
									<MenuItem name="客户信息管理">客户信息管理</MenuItem>
								</router-Link>
								<router-Link to="/kdyInfo">
									<MenuItem name="快递员管理">快递员管理</MenuItem>
								</router-Link>
								<router-Link to="/adminInfo">
									<MenuItem name="管理员管理">管理员管理</MenuItem>
								</router-Link>
							</Submenu>
							<Submenu name="系统报表">
								<template slot="title">
									<Icon type="ios-people"></Icon>
									系统报表
								</template>
								<router-Link to="/orders">
									<MenuItem name="订单统计报表">订单统计报表</MenuItem>
								</router-Link>
							</Submenu>
						</div>
						<Submenu name="个人信息">
							<template slot="title">
								<Icon type="ios-people"></Icon>
								个人信息
							</template>
							<router-Link to="/myinfo">
								<MenuItem name="我的信息">我的信息</MenuItem>
							</router-Link>
						</Submenu>
					</Menu>
				</Sider>
				<!--右边-->
				<Layout>
					<!--导航栏-->
					<Breadcrumb :style="{margin: '5px'}">
						<span>
							<Icon type="ios-pin-outline" />
							当前位置：</span>
						<span>{{ parentTag }}</span>
						<span>{{ childTag }}</span>
						<span style="float: right; margin-right: 20px;">{{years}}</span>
					</Breadcrumb>
					<!--内容-->
					<Content :style="{padding: '0 25px', minHeight: '280px', background: '#fff'}">
						<router-view>

						</router-view>
					</Content>
				</Layout>
			</Layout>
		</Layout>
	</div>
</template>
<script>
	export default {
		data() {
			return {
				years: "",
				role: '管理员',
				theme: "primary",
				parentTag: "控制台",
				modal13: false,
				childTag: "",
				info: '',
				user: {
					password: "",
					passwords: "",
					passwordss: ""
				}
			}
		},
		methods: {
			logout() {
				this.$Message.success("成功退出！");
				localStorage.setItem("User", '');
				setTimeout(function() {
					window.location.href = "/";
				}, 900);
			},
			ok() {
				var th = this;
				if (th.user.password == th.user.passwords) {
					th.$Message.warning("旧密码和新密码相同！");
					th.modal13show();
					return;
				}
				if (th.user.passwords != th.user.passwordss) {
					th.$Message.warning("两次密码不一致");
					th.modal13show();
					return;
				}
				if (th.info.password != th.user.password) {
					th.$Message.warning("旧密码错误！");
					th.modal13show();
					return;
				}
				th.info.password = th.user.passwordss;
				axios.post('/ex/personnelInfo/updateByPrimaryKey', th.info, {
					headers: {
						"Content-Type": "application/json;charset=utf-8"
					}
				}).then(function(res) {
					if (res.data.code == 200) {
						th.$Message.success("修改成功！");
						localStorage.setItem("User", '');
						setTimeout(function() {
							window.location.href = "/";
						}, 500);
					} else {
						th.$Message.error("修改失败！");
					}
				})
			},
			modal13show() {
				this.modal13 = false;
				setTimeout(() => {
					this.modal13 = true;
				}, 1000);
			},
			updatepassword() {
				this.modal13 = true;
			},
			fu(e) {
				this.parentTag = e[0];
				this.childTag = "";
			},
			ze(e) {
				this.childTag = " > " + e;
			},
			topfu(e) {
				this.parentTag = e;
				this.childTag = "";
			},
		},
		created() {
			if (localStorage.getItem('User') == '') {
				window.location.href = "/";
			} else {
				this.info = JSON.parse(localStorage.getItem("User"));
				console.log(this.info)
				this.role = this.info.role;
				if (this.role == null || this.role == '') {
					window.location.href = "/#/index";
				}
				var data = new Date();
				this.years = data.getFullYear() + "年" + (data.getMonth() + 1) + "月" + data.getDate() + "日";
			}

		}
	}
</script>
