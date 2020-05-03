<template>
		<div style="margin: auto;margin-top: 2%; width: 80%;">
	<Form ref="formValidate" :model="waybill" :rules="rules" :label-width="120">
		<h1 style="text-align: center;">快速下单中心</h1>
		<br/>
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
			<FormItem label="寄件人姓名" prop="jName">
				<Input v-model="waybill.jName" disabled></Input>
			</FormItem>
			</Col>

			<Col span="12">
			<FormItem label="寄件人手机" prop="jPhone">
				<Input v-model="waybill.jPhone" maxlength=11  disabled></Input>
			</FormItem>
			</Col>
		</Row>
		<Row>
			<Col span="12">
			<FormItem label="重量(kg)" prop="weight">
				<InputNumber style="width:100%" :min="1" v-model="weights"></InputNumber>
			</FormItem>
			</Col>
			<Col span="12">
			<FormItem label="寄件地址" prop="jName">
				<Input v-model="waybill.jAddress" placeholder="寄件地址"></Input>
			</FormItem>
			</Col>
		</Row>
		<Row>
			<Col span="12">
			<FormItem label="收件人姓名" prop="sName">
				<Input v-model="waybill.sName" placeholder="收件人姓名"></Input>
			</FormItem>
			</Col>
			<Col span="12">
			<FormItem label="收件人手机" prop="sPhone">
				<Input v-model="waybill.sPhone" :maxlength=11 placeholder="请输入收件人手机"></Input>
			</FormItem>
			</Col>
		</Row>
		<Row>
			<Col span="12">
			<FormItem label="收件地址" prop="sAddress">
				<Input v-model="waybill.sAddress" placeholder="收件地址"></Input>
			</FormItem>
			</Col>
		</Row>
		<Button type="success" style="width:100%" onclick="return false" @click="addok()">立即预订</Button>
	</Form>
	</div>
</template>
<script>
	export default {
		data() {
			return {
				weights: 1,
				waybill: {
					waybillNo: '全部',
					weight: 1,
					price: 12,
					jName: '',
					jPhone: '',
					jAddress: '',
					sName: '',
					sPhone: '',
					sAddress: '',
					wStatus: ''
				},
				rules: {
					weight: [{
						required: true,
						message: '重量为数字',
						trigger: 'blur'
					}],
					jAddress: [{
						required: true,
						message: '寄件人地址不能为空',
						trigger: 'blur'
					}],
					sName: [{
						required: true,
						message: '收件人姓名不能为空',
						trigger: 'blur'
					}],
					sPhone: [{
						required: true,
						message: '收件人手机不能为空',
						trigger: 'blur'
					}],
					sAddress: [{
						required: true,
						message: '收件人地址不能为空',
						trigger: 'blur'
					}],
				},
			}
		},
		watch: {
			weights: function(weights) {
				this.waybill.weight = weights;
				var weight = Math.ceil(weights);
				if (weight <= 4) {
					this.waybill.price = 12;
				} else {
					this.waybill.price = 12 + ((weight - 4) * 5)
				}
			}
		},
		methods: {
			//添加保存
			addok() {
				const th = this;
				axios.post('/ex/waybill/insert', th.waybill, {
					headers: {
						"Content-Type": "application/json;charset=utf-8"
					}
				}).then(function(res) {
					if (res.data.code === 200) {
						th.$Message.success("下单成功");
						th.waybill = {
							waybillNo: '',
							weight: 1,
							price: 12,
							sName: '',
							sPhone: '',
							sAddress: '',
							wStatus: ''
						};
						th.setuuid();
					} else {
						th.$Message.error(res.data.message);
					}
				})
			},
			addUserInfo() {
				let info = JSON.parse(localStorage.getItem("User"));
				this.waybill.jName = info.pName;
				this.waybill.jPhone = info.phone;
			},
			setuuid() {
				var timestamp = new Date().getTime().toString();
				timestamp = "DDHM" + Math.round(Math.random() * 10) + timestamp.substring(5, timestamp.length - 1) + Math.round(
					Math.random() * 10) + Math.round(
					Math.random() * 10);
				this.waybill.waybillNo = timestamp;
			}
		},
		created() {
			this.setuuid();
			this.addUserInfo();
		}
	}
</script>
