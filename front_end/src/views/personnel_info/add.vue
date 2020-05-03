<template>
	<Form ref="formValidate" :model="positions" :label-width="120">
		<h1 style="text-align: center;">订单位置录入中心</h1>
		<FormItem label="运单号" prop="waybillNo">
			<Input v-model="positions.waybillNo" placeholder="请输入运单号"></Input>
		</FormItem>
		<FormItem label="当前位置" prop="dPosition">
			<Input v-model="positions.dPosition" :maxlength=11 placeholder="请输入当前位置"></Input>
		</FormItem>
		<FormItem label="下一站位置" prop="xPosition">
			<Input v-model="positions.xPosition" placeholder="请输入下一站位置"></Input>
		</FormItem>
		<Button type="success" style="width:100%" onclick="return false" @click="addok()">立即录入</Button>
	</Form>
</template>
<script>
	export default {
		data() {
			return {
				positions: {
					waybillNo: '',
					dPosition: '',
					xPosition: ''
				}
			}
		},
		methods: {
			//添加保存
			addok() {
				if (this.positions.waybillNo != null && this.positions.waybillNo.length < 1) {
					this.$Message.warning('请输入运单号!');
					this.modal14show();
					return;
				}
				if (this.positions.dPosition != null && this.positions.dPosition.length < 1) {
					this.$Message.warning('请输入下一站当前位置!');
					this.modal14show();
					return;
				}
				if (this.positions.xPosition != null && this.positions.xPosition.length < 1) {
					this.$Message.warning('请输入下一站位置信息!');
					this.modal14show();
					return;
				}
				const th = this;
				axios.post('/ex/positions/insert', th.positions, {
					headers: {
						"Content-Type": "application/json;charset=utf-8"
					}
				}).then(function(res) {
					if (res.data.code === 200) {
						th.$Message.success("订单位置录入成功！");
						th.positions = {
							waybillNo: '',
							dPosition: '',
							xPosition: ''
						}
					} else {
						th.$Message.error("订单位置录入失败！");
					}
				})
			},
			modal14show() {
				this.modal14 = false;
				setTimeout(() => {
					this.modal14 = true;
				}, 0);
			},
		},
		created() {

		}
	}
</script>
