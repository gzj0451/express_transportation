<template>
	<div style="margin: auto;margin-top: 10%; width: 80%;">
		<Form ref="formValidate" :model="personnelInfo" :label-width="80">
			<Row>
				<Col span="12">
				<FormItem label="编号" prop="pId">
					<Input v-model="personnelInfo.pId" disabled></Input>
				</FormItem>
				</Col>
				
				<Col span="12">
				<FormItem label="手机号码" prop="phone">
					<Input v-model="personnelInfo.phone" disabled></Input>
				</FormItem>
				</Col>
			</Row>
			<Row>
				<Col span="12">
				<FormItem label="姓名" prop="pName">
					<Input v-model="personnelInfo.pName" ></Input>
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
			</Row>
			<Button type="success" style="width:100%" onclick="return false" @click="addok()">立即修改</Button>
		</Form>
	</div>
</template>
<script>
	export default {
		data() {
			return {
				personnelInfo: {
					
				},
			}
		},
		methods: {
			//弹出添加保存
			addok() {
				if (this.personnelInfo.pName!= null && this.personnelInfo.pName.length < 1) {
					this.$Message.warning('请输入姓名!');
					return;
				}
				const th = this;
				axios.post('/ex/personnelInfo/updateByPrimaryKey' , th.personnelInfo, {
					headers: {
						"Content-Type": "application/json;charset=utf-8"
					}
				}).then(function(res) {
					if (res.data.code === 200) {
						th.$Message.success(res.data.message);
						localStorage.setItem('User', JSON.stringify(th.personnelInfo));
						setTimeout(function() {
							location.reload();
						}, 900);
						
					} else {
						th.$Message.error(res.data.message);
					}
				})
			}
		},
		created() {
			this.personnelInfo = JSON.parse(localStorage.getItem("User"));
		}
	}
</script>
