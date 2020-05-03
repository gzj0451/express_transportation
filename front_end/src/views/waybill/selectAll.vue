<style>
	.ivu-table td, .ivu-table-border td{
		height: 41px;
	}
</style>
<template>
	<div>
		<div class="rigtop">
			<Form ref="pharmacyOrders" inline>
				<FormItem>
					<Row>
						<Col span="8" style="text-align: center;">
						<Checkbox label="运单号" v-model="waybillNo">运单号</Checkbox>
						</Col>
						<Col span="16">
						<Input height="20" placeholder="模糊查询运单号" v-model="waybillNos"></Input>
						</Col>
					</Row>
				</FormItem>
				<FormItem>
					订单状态
					<RadioGroup v-model="wStatuss">
						<Radio label="全部">
							<Icon type="ios-eye" />
							<span>全部</span>
						</Radio>
						<Radio label="待揽收">
							<Icon type="ios-eye-off" />
							<span>待揽收</span>
						</Radio>
						<Radio label="运输中">
							<Icon type="ios-eye" />
							<span>运输中</span>
						</Radio>
						<Radio label="已完成">
							<Icon type="ios-eye-off" />
							<span>已完成</span>
						</Radio>
					</RadioGroup>
				</FormItem>
				<FormItem style="position: relative;left: 10px">
					<Button @click="changePage(1)">
						<Icon type="ios-sync" />快速查询
					</Button>
				</FormItem>
				<FormItem style="position: absolute;right: 30px">
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
			<Form :model="evaluate" :label-width="120" >
					<FormItem label="运单号"  >
						<Input v-model="evaluate.waybillNo" disabled></Input>
					</FormItem>
					<FormItem label="评价分数" prop="branch">
						<Rate show-text v-model="evaluate.branch" :disabled='disableds'/>
					</FormItem>
					<FormItem label="评价内容" prop="pContent">
						<Input v-model="evaluate.pContent" type="textarea" :disabled='disableds' :autosize="{minRows: 2,maxRows: 5}"></Input>
					</FormItem>
					<FormItem label="投诉内容" prop="tContent">
						<Input v-model="evaluate.tContent" type="textarea" :disabled='disableds' :autosize="{minRows: 2,maxRows: 5}"></Input>
					</FormItem>
			</Form>
		</Modal>
		<Modal v-model="modal15" width="80%" scrollable title="详细信息" >
			<Form :model="waybill" :label-width="120" >
					<Row>
						<Col span="12">
						<FormItem label="运单号" prop="waybillNo">
							<Input v-model="waybill.waybillNo" disabled></Input>
						</FormItem>
						</Col>
						<Col span="12">
						<FormItem label="价格" prop="price">
							<Input v-model="waybill.price" disabled></Input>
						</FormItem>
						</Col>
					</Row>
					<Row>
						<Col span="12">
						<FormItem label="重量(kg)" prop="weight">
							<Input v-model="waybill.jName" disabled></Input>
						</FormItem>
						</Col>
						<Col span="12">
						<FormItem label="寄件人姓名" prop="jName">
							<Input v-model="waybill.jName" disabled></Input>
						</FormItem>
						</Col>
					</Row>
					<Row>
						<Col span="12">
						<FormItem label="寄件人手机" prop="jPhone">
							<Input v-model="waybill.jPhone"  disabled ></Input>
						</FormItem>
						</Col>
						<Col span="12">
						<FormItem label="寄件地址" prop="jName">
							<Input v-model="waybill.jAddress" disabled ></Input>
						</FormItem>
						</Col>
					</Row>
					<Row>
						<Col span="12">
						<FormItem label="收件人姓名" prop="sName">
							<Input v-model="waybill.sName" disabled ></Input>
						</FormItem>
						</Col>
						<Col span="12">
						<FormItem label="收件人手机" prop="sPhone">
							<Input v-model="waybill.sPhone" disabled ></Input>
						</FormItem>
						</Col>
					</Row>
					<Row>
						<Col span="12">
						<FormItem label="收件地址" prop="sAddress">
							<Input v-model="waybill.sAddress" disabled ></Input>
						</FormItem>
						</Col>
						<Col span="12">
						<FormItem label="订单状态" prop="wStatus">
							<Input v-model="waybill.wStatus" disabled ></Input>
						</FormItem>
						</Col>
					</Row>
					<Row>
						<Col span="12">
						<FormItem label="快递员姓名" prop="sAddress">
							<Input v-model="waybill.kdyName" disabled ></Input>
						</FormItem>
						</Col>
						<Col span="12">
						<FormItem label="快递员手机号码" prop="wStatus">
							<Input v-model="waybill.kdyPhone" disabled ></Input>
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
				wStatuss: "全部",
				waybillNos: '',
				waybillNo: false,
				info: {
					pId: 5,
					pName: 'wbg',
					sex: '男',
					birthhday: '',
					password: '',
					role: '管理员',
					phone: '18776203778'
				},
				evaluate: {
					waybillNo: "",
					kdyId:'',
					kdyName:'',
					khName:'',
					branch: 5,
					pContent: "",
					tContent: "",
				},
				modal14: false,
				loading: true,
				modal14loading: true,
				modal15: false,
				modal15loading: true,
				title: '添加货主',
				count: 10,
				columns7: [{
						title: '运单号',
						key: 'waybillNo',
						align: 'center',
						width: 100
					}, {
						title: '重量',
						key: 'weight',
						align: 'center',
						width: 100
					}, {
						title: '价格',
						key: 'price',
						tooltip: true,
						align: 'center'
					},
					{
						title: '寄件人',
						key: 'jName',
						align: 'center'
					},
					{
						title: '收件人',
						key: 'sName',
						align: 'center'
					},
					{
						title: '订单状态',
						key: 'wStatus',
						align: 'center',
					},
					{
						title: '操作',
						key: 'action',
						width: 290,
						align: 'center',
						render: (h, params) => {
							//取消订单
							var ddqx = {
								props: {
									type: 'primary',
									size: 'small'
								},
								style: {
									marginRight: '5px'
								},
								on: {
									click: () => {
										this.ddqx(params.row)
									}
								}
							};
							//立即揽件
							var ljlj = {
								props: {
									type: 'primary',
									size: 'small'
								},
								style: {
									marginRight: '5px'
								},
								on: {
									click: () => {
										this.ljlj(params.row)
									}
								}
							};

							//立即派件
							var ljpj = {
								props: {
									type: 'primary',
									size: 'small'
								},
								style: {
									marginRight: '5px'
								},
								on: {
									click: () => {
										this.ljpj(params.row)
									}
								}
							};
							//投诉
							var ts = {
								props: {
									type: 'primary',
									size: 'small'
								},
								style: {
									marginRight: '5px'
								},
								on: {
									click: () => {
										this.ts(params.row)
									}
								}
							};
							//详细
							var xx = {
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
							};
							if (this.info.role == "管理员") {
								if (params.row.wStatus == "待揽收") {
									return h('div', [
										h('Button', ddqx, '订单取消'),
										h('Button', ljlj, '立即揽件'),
										h('Button', xx, '详细'),
									]);
								} else if (params.row.wStatus == "运输中") {
									return h('div', [
										h('Button', ljpj, '派件完成'),
										h('Button', xx, '详细'),
									]);
								} else {
									return h('div', [
										h('Button', ts, '评价/投诉'),
										h('Button', xx, '详细'),
									]);
								}
							}

							//待揽收  发件人||快递员
							if (params.row.wStatus == "待揽收") {
								//发件人
								if (params.row.jPhone == this.info.phone) {
									return h('div', [
										h('Button', ddqx, '订单取消'),
										h('Button', xx, '详细'),
									]);
								}
								//快递员
								else {
									return h('div', [
										h('Button', ljlj, '立即揽件'),
										h('Button', xx, '详细'),
									]);
								}
							}
							//运输中  快递员
							else if (params.row.wStatus == "运输中" && params.row.kdyPhone == this.info.phone) {
								return h('div', [
									h('Button', ljpj, '派件完成'),
									h('Button', xx, '详细'),
								]);
							}
							//已完成 发件人
							else if (params.row.wStatus == "已完成" && params.row.jPhone == this.info.phone) {
								//发件人
								if (params.row.jPhone == this.info.phone) {
									return h('div', [
										h('Button', ts, '评价/投诉'),
										h('Button', xx, '详细'),
									]);
								}
							} else {
								return h('div', [
									h('Button', xx, '详细'),
								]);
							}

						}
					}
				],
				data6: [],
				disableds:true,
				pharmacyOrders: {
					pId: 0,
					status: "已完成",
					memarks: new Date(),
				},
				waybill:{
				},
			}
		},
		methods: {
			//单击编辑
			show(data) {
				this.modal15 = true;
				this.waybill = data;
			},
			//评价
			addok() {
				
				if(this.disableds){
					this.modal14 = false;
					return;
				}
				const th = this;
				axios.post('/ex/evaluate/insert', th.evaluate, {
					headers: {
						"Content-Type": "application/json;charset=utf-8"
					}
				}).then(function(res) {
					if (res.data.code === 200) {
						th.$Message.success("评价/投诉成功");
						th.modal14 = false;
						th.changePage(1);
						
					} else {
						th.$Message.error("评价/投诉失败！");
					}
				})
			},
			modal14show() {
				this.modal14 = false;
				setTimeout(() => {
					this.modal14 = true;
				}, 0);
			},
			//导出数据
			exportData() {
				this.$refs.table.exportCsv({
					filename: '导出数据'
				});
			},
			//订单取消
			ddqx(datas) {
				this.$Modal.confirm({
					title: '订单取消',
					content: '<p>取消后不可恢复，确定继续？</p>',
					onOk: () => {
						const th = this;
						axios.get('/ex/waybill/deleteByPrimaryKey', {
							params: {
								id: datas.waybillNo
							}
						}).then(function(res) {
							if (res.data.code === 200) {
								th.$Message.success("订单取消成功！");
								th.changePage(1);
							} else {
								th.$Message.error("订单取消失败！");
							}
						})
					}
				});
			},
			//立即揽件
			ljlj(data) {
				this.$Modal.confirm({
					title: '揽件' + data.waybillNo,
					content: '<p>是否已经揽收快件->' + data.waybillNo + '</p><p>揽件后不可操作！</p>',
					onOk: () => {
						var waybill = {
							waybillNo: data.waybillNo,
							kdyId: this.info.pId,
							kdyName: this.info.pName,
							kdyPhone: this.info.phone,
							wStatus: "运输中"
						}
						const th = this;
						axios.post('/ex/waybill/updateByPrimaryKey', waybill, {
							headers: {
								"Content-Type": "application/json;charset=utf-8"
							}
						}).then(function(res) {
							if (res.data.code === 200) {
								th.$Message.success("揽件成功！");
								th.changePage(1);
							} else {
								th.$Message.error("揽件失败！");
							}
						})
					}
				});
			},
			//立即派件
			ljpj(data) {
				this.$Modal.confirm({
					title: '派件' + data.waybillNo + '完成',
					content: '<p>是否已经派件->' + data.waybillNo + '完成</p><p>完成请继续！</p>',
					onOk: () => {
						var waybill = {
							waybillNo: data.waybillNo,
							wStatus: "已完成"
						}
						const th = this;
						axios.post('/ex/waybill/updateByPrimaryKey', waybill, {
							headers: {
								"Content-Type": "application/json;charset=utf-8"
							}
						}).then(function(res) {
							if (res.data.code === 200) {
								th.$Message.success("派件成功！");
								th.changePage(1);
							} else {
								th.$Message.error("派件失败！");
							}
						})
					}
				});
			},
			//投诉
			ts(data) {
				this.title = '评价/投诉'
				this.evaluate.waybillNo=data.waybillNo;
				this.evaluate.kdyId=data.kdyId;
				this.evaluate.kdyName=data.kdyName;
				this.evaluate.khName=data.jName;
				this.evaluate.pContent="";
				this.evaluate.tContent="";
				const th = this;
				axios.get('/ex/evaluate/selectByPrimaryKey', {
					params: {
						waybillNo: data.waybillNo
					}
				}).then(function(res) {
					if(res.data.data){
						var data = res.data.data;
						th.evaluate.eId=data.eId;
						th.evaluate.waybillNo=data.waybillNo;
						th.evaluate.kdyId=data.kdyId;
						th.evaluate.kdyName=data.kdyName;
						th.evaluate.khName=data.khName;
						th.evaluate.branch=parseInt(data.branch);
						th.evaluate.pContent=data.pContent;
						th.evaluate.tContent=data.tContent;
						th.modal14 = true;
						th.disableds = true;
					}else{
						th.modal14 = true;
						th.disableds = false;
					}
				})
			},
			changePage(page) {
				const th = this;
				th.loading = true;
				if (!th.waybillNo) {
					th.waybillNos = '';
				}
				var status = '';
				if (th.wStatuss != '全部') {
					status = th.wStatuss;
				}
				console.log(th.info.role)
				axios.get('/ex/waybill/selectPage', {
					params: {
						page: page,
						waybillNo: th.waybillNos,
						role: th.info.role,
						wStatus: status,
						phone: th.info.phone,
					}
				}).then(function(res) {
					th.data6 = res.data.data;
					th.count = res.data.count;
				})
				th.loading = false;
			},
		},
		created() {
			this.info = JSON.parse(localStorage.getItem("User"));
			this.changePage(1);
		}
	}
</script>
