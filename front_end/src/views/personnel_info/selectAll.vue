<style>
	.ivu-table td, .ivu-table-border td{
		height: 41px;
	}
</style>
<template>
	<div>
		<div class="rigtop">
			<Form inline>
				<FormItem>
					<Row>
						<Col span="8" style="text-align: center;">
						<Checkbox label="订单编号" v-model="sPIds">订单编号</Checkbox>
						</Col>
						<Col span="16">
						<Input height="20" placeholder="模糊查询订单编号" v-model="sPId"></Input>
						</Col>
					</Row>
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
		<Modal v-model="modal14"  scrollable :title="title">
			<Form :model="evaluate" :label-width="120" >
					<FormItem label="运单号"  >
						<Input v-model="evaluate.waybillNo" disabled></Input>
					</FormItem>
					<FormItem label="评价分数" prop="branch">
						<Rate show-text v-model="evaluate.branch" disabled/>
					</FormItem>
					<FormItem label="评价内容" prop="pContent">
						<Input v-model="evaluate.pContent" type="textarea" disabled :autosize="{minRows: 2,maxRows: 5}"></Input>
					</FormItem>
					<FormItem label="投诉内容" prop="tContent">
						<Input v-model="evaluate.tContent" type="textarea" disabled :autosize="{minRows: 2,maxRows: 5}"></Input>
					</FormItem>
			</Form>
		</Modal>
	</div>
</template>
<script>
	export default {
		data() {
			return {
				sPId: '',
				sName: '',
				sPIds: false,
				sNames: false,
				modal14: false,
				loading: true,
				modal14loading: true,
				title: '配送',
				count: 10,
				columns7: [{
						title: '运单号',
						key: 'waybillNo',
						align: 'center',
						width: 200
					}, {
						title: '当前位置',
						key: 'dPosition',
						align: 'center',
						width: 150
					},
					{
						title: '下一站位置',
						key: 'xPosition',
						align: 'center',
						tooltip: true
					},
					{
						title: '更新时间',
						key: 'pTime',
						align: 'center'
					}
				],
				evaluate:{},
				data6: [],
			}
		},
		methods: {
			//单击编辑
			show(data) {
				this.modal14 = true;
				this.evaluate = data;
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
					filename: '报表导出'
				});
			},
			changePage(page) {
				const th = this;
				th.loading = true;
				if (!th.sPIds) {
					th.sPId = '';
				}
				axios.get('/ex/positions/selectPage', {
					params: {
						page: page,
						waybillNo: th.sPId
					}
				}).then(function(res) {
					if(res.data.data == null){
						return;
					}
					th.data6 = res.data.data;
					th.count = res.data.count;
				})
				th.loading = false;
			},
		},
		created() {
			this.changePage(1);
		}
	}
</script>
