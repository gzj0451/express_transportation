<style>
	.ivu-table td, .ivu-table-border td{
		height: 41px;
	}
</style>
<template>
	<div>
		<div class="rigtop">
			<Form ref="personnelInfo" inline>
				<FormItem>
					<Row>
						<Col span="8" style="text-align: center;">
						<Checkbox label="姓名" v-model="sNames">姓名</Checkbox>
						</Col>
						<Col span="16">
						<Input height="20" placeholder="模糊查询姓名" v-model="sName"></Input>
						</Col>
					</Row>
				</FormItem>
				<FormItem>
					<Row>
						<Col span="8" style="text-align: center;">
						<Checkbox label="手机号码" v-model="sPhones">手机号码</Checkbox>
						</Col>
						<Col span="16">
						<Input height="20" placeholder="模糊查询手机号码" v-model="sPhone"></Input>
						</Col>
					</Row>
				</FormItem>
				<FormItem>
					性别 :
					<RadioGroup v-model="sex">
						<Radio label="">
							<Icon type="ios-eye" />
							<span>全部</span>
						</Radio>
						<Radio label="男">
							<Icon type="ios-eye" />
							<span>男</span>
						</Radio>
						<Radio label="女">
							<Icon type="ios-eye-off" />
							<span>女</span>
						</Radio>
					</RadioGroup>
				</FormItem>
				<FormItem style="position: relative;left: 10px">
					<Button @click="changePage(1)">
						<Icon type="ios-sync" />快速查询
					</Button>
				</FormItem>
				<FormItem style="position: absolute;right: 30px">
					<FormItem>
						<Button @click="add()">
							<Icon type="ios-add-circle-outline" />添加记录
						</Button>
					</FormItem>
					<Button @click="exportData()">
						<Icon type="ios-download-outline" />数据导出
					</Button>
				</FormItem>
			</Form>
		</div>
		<Table border :columns="columns7" :data="data6" height="450" :loading="loading" stripe size='default' ref="table"></Table>
		<div style="margin: 10px;overflow: hidden">
			<div style="float: right;">
				<Page :total="count" :current="1" @on-change="changePage($event)"></Page>
			</div>
		</div>
		<Modal v-model="modal14" :loading="modal14loading" scrollable :title="title" @on-ok="addok">

			<Form ref="formValidate" :model="personnelInfo" :label-width="80">
				<Row>
					<Col span="12">
					<FormItem label="姓名" prop="name">
						<input type="hidden" v-model="personnelInfo.pId" />
						<Input v-model="personnelInfo.pName" :maxlength=6 placeholder="请输入姓名"></Input>
					</FormItem>
					</Col>
					<Col span="12">
					<FormItem label="性别" prop="sex">
						<RadioGroup v-model="personnelInfo.sex">
							<Radio label="男"></Radio>
							<Radio label="女"></Radio>
						</RadioGroup>
					</FormItem>
					</Col>
				</Row>
				<Row>
					<Col span="12">
					<FormItem label="出生日期" prop="birthhday">
						<DatePicker type="date" placeholder="Select date" style="width: 100%" v-model="personnelInfo.birthhday"></DatePicker>
					</FormItem>
					</Col>
					<Col span="12">
					<FormItem label="手机号码" prop="phone">
						<Input v-model="personnelInfo.phone" :maxlength=11 placeholder="请输入手机号码"></Input>
					</FormItem>
					</Col>
				</Row>
				<Row>
					<Col span="12">
					<FormItem label="密码" prop="password">
						<Input type="password" v-model="personnelInfo.password" maxlength=16 placeholder="请输入密码"></Input>
					</FormItem>
					</Col>
					<Col span="12">
					<FormItem label="角色" prop="role">
						<Select v-model="personnelInfo.role" style="width:162px">
							<Option v-for="item in Lists" :value="item.value" :key="item.value">{{ item.label }}</Option>
						</Select>
					</FormItem>
					</Col>
				</Row>
			</Form>
		</Modal>

	</div>
</template>
<script>
	export default {
		data() {
			return {
				sex: "",
				sPhone: '',
				sName: '',
				role: '管理员',
				Lists: [{
						value: '管理员',
						label: '管理员'
					},
					{
						value: '客户',
						label: '客户'
					},
					{
						value: '快递员',
						label: '快递员'
					}
				],
				sPhones: false,
				sNames: false,
				modal14: false,
				loading: true,
				modal14loading: true,
				title: '添加货主',
				count: 10,
				columns7: [{
						title: '编号',
						key: 'pId',
						align: 'center',
						width: 100
					},
					{
						title: '姓名',
						key: 'pName',
						align: 'center',
						tooltip: true
					},
					{
						title: '性别',
						key: 'sex',
						align: 'center'
					},
					{
						title: '出生日期',
						key: 'birthhday',
						align: 'center',
						render: (h, params) => {
							return h('div', [
								h('span', {
									style: {
										display: 'inline-block',
										width: '100%',
										overflow: 'hidden',
										textOverflow: 'ellipsis',
										whiteSpace: 'nowrap'
									}
								}, params.row.birthhday.substring(0,10))
							])
						}
					},
					{
						title: '手机号码',
						key: 'phone',
						align: 'center',
					},
					{
						title: '操作',
						key: 'action',
						width: 150,
						align: 'center',
						render: (h, params) => {
							return h('div', [
								h('Button', {
									props: {
										type: 'primary',
										size: 'small'
									},
									style: {
										marginRight: '5px'
									},
									on: {
										click: () => {
											this.show(params.row)
										}
									}
								}, '编辑'),
								h('Button', {
									props: {
										type: 'error',
										size: 'small'
									},
									on: {
										click: () => {
											this.remove(params.row.pId)
										}
									}
								}, '移除')
							]);
						}
					}
				],
				data6: [],
				personnelInfo: {
					pId: 0,
					pName: '',
					sex: '男',
					birthhday: '',
					password: '',
					role: '管理员',
					phone: ''
				},
			}
		},
		watch: {
			$route(to, from) {
				let path = this.$route.path;
				if (path == "/khInfo") {
					this.role = "客户";
				} else if (path == "/kdyInfo") {
					this.role = "快递员";
				} else {
					this.role = "管理员";
				}
					this.sPhones = false,
					this.sNames = false,
					this.changePage(1);
			}
		},
		methods: {
			//单击添加
			add() {
				this.title = "添加信息";
				this.personnelInfo.phone = "";
				this.personnelInfo.pName = "";
				this.personnelInfo.password = "";
				this.modal14 = true;
			},
			//单击编辑
			show(data) {
				this.title = '编辑信息'
				this.modal14 = true;
				this.personnelInfo.pId = data.pId;
				this.personnelInfo.phone = data.phone;
				this.personnelInfo.pName = data.pName;
				this.personnelInfo.sex = data.sex;
				this.personnelInfo.birthhday = data.birthhday;
				this.personnelInfo.password = data.password;
				this.personnelInfo.role = data.role;
			},
			//弹出添加保存
			addok() {
				if (this.personnelInfo.name != null && this.personnelInfo.name.length < 1) {
					this.$Message.warning('请输入名字!');
					this.modal14show();
					return;
				}
				if (this.personnelInfo.phone != null && this.personnelInfo.phone.length < 1 || this.personnelInfo.phone.length !=
					11) {
					this.$Message.warning('电话号码不正确，需要11位手机号码!');
					this.modal14show();
					return;
				}
				if (this.personnelInfo.password != null && this.personnelInfo.password.length < 6) {
					this.$Message.warning('密码不正确,需要6位以上!');
					this.modal14show();
					return;
				}
				const th = this;
				var urls = "insert";
				if (this.title == "编辑信息") {
					urls = "updateByPrimaryKey";
				}
				axios.post('/ex/personnelInfo/' + urls, th.personnelInfo, {
					headers: {
						"Content-Type": "application/json;charset=utf-8"
					}
				}).then(function(res) {
					if (res.data.code === 200) {
						th.$Message.success(res.data.message);
						th.modal14 = false;
						th.changePage(1);
					} else {
						th.modal14show();
						if (res.data.message.indexOf(th.personnelInfo.phone) > 0) {
							th.$Message.error("手机号码重复");
						} else {
							th.$Message.error(res.data.message);
						}

					}
				})


			},
			modal14show() {
				this.modal14 = false;
				setTimeout(() => {
					this.modal14 = true;
				}, 0);
			},
			//删除操作
			remove(id) {
				this.$Modal.confirm({
					title: '删除提示',
					content: '<p>移除后不可恢复，确定继续？</p>',
					onOk: () => {
						const th = this;
						axios.get('/ex/personnelInfo/deleteByPrimaryKey', {
							params: {
								id: id
							}
						}).then(function(res) {
							console.log(res)
							if (res.data.code === 200) {
								th.$Message.success(res.data.message);
								th.changePage(1);
							} else {
								th.$Message.error(res.data.message);
							}
						})
					}
				});
			},
			//导出数据
			exportData() {
				this.$refs.table.exportCsv({
					filename: '人员信息'
				});
			},
			changePage(page) {
				const th = this;
				th.loading = true;
				if (!th.sPhones) {
					th.sPhone = '';
				}
				if (!th.sNames) {
					th.sName = '';
				}
				axios.get('/ex/personnelInfo/selectPage', {
					params: {
						page: page,
						phone: th.sPhone,
						name: th.sName,
						sex: th.sex,
						role: th.role
					}
				}).then(function(res) {
					th.data6 = res.data.data;
					th.count = res.data.count;
					th.loading = false;
				})

			},
		},
		created() {
let path = this.$route.path;
				if (path == "/khInfo") {
					this.role = "客户";
				} else if (path == "/kdyInfo") {
					this.role = "快递员";
				} else {
					this.role = "管理员";
				}
					this.sPhones = false,
					this.sNames = false,
					this.changePage(1);
		}
	}
</script>
