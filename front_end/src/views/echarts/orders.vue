<template>
	<div>
		<Row>
			<Col span="12" style="text-align: center;">
			<div style="background-color: #2d8cf0;height: 120px;margin: 30px;border-radius: 5%; ">
				<Icon type="logo-usd" size="100"  />
				<div style="background-color: #f5f7f9;height: 25px;">
					<span style="font-size: 16px;position:relative;float:left;left: 10px;">平台交易总金额</span>
					<span style="font-size: 16px;position:relative;float:right;right: 10px;">{{orders.price}}</span>
				</div>
			</div>
			</Col>
			<Col span="12" style="text-align: center;">
			<div style="background-color: #2d8cf0;height: 120px;margin: 30px;border-radius: 5%; ">
				<Icon type="md-medal" size="100" />
				<div style="background-color: #f5f7f9;height: 25px;">
					<span style="font-size: 16px;position:relative;float:left;left: 10px;">平台交易总订单</span>
					<span style="font-size: 16px;position:relative;float:right;right: 10px;">{{orders.zs}}</span>
				</div>
			</div>
			</Col>
		</Row>
		<Row style="margin: 30px;margin-top:0px ;">
			<Col span="8" style="text-align: center;">
			<div style="background-color: #2d8cf0;height: 120px;margin: 30px;border-radius: 5%; ">
				<Icon type="md-checkmark-circle-outline" size="100" />
				<div style="background-color: #f5f7f9;height: 25px;">
					<span style="font-size: 16px;position:relative;float:left;left: 10px;">已完成</span>
					<span style="font-size: 16px;position:relative;float:right;right: 10px;">{{orders.ywc}}</span>
				</div>
			</div>
			</Col>
			<Col span="8" style="text-align: center;">
			<div style="background-color: #2d8cf0;height: 120px;margin: 30px;border-radius: 5%; ">
				<Icon type="md-boat" size="100" />
				<div style="background-color: #f5f7f9;height: 25px;">
					<span style="font-size: 16px;position:relative;float:left;left: 10px;">运输中</span>
					<span style="font-size: 16px;position:relative;float:right;right: 10px;">{{orders.ysz}}</span>
				</div>
			</div>
			</Col>
			<Col span="8" style="text-align: center;">
			<div style="background-color: #2d8cf0;height: 120px;margin: 30px;border-radius: 5%; ">
				<Icon type="ios-brush-outline"size="100"  />
				<div style="background-color: #f5f7f9;height: 25px;">
					<span style="font-size: 16px;position:relative;float:left;left: 10px;">待揽收</span>
					<span style="font-size: 16px;position:relative;float:right;right: 10px;">{{orders.dls}}</span>
				</div>
			</div>
			</Col>
		</Row>
	</div>
</template>
<script>
	export default {
		data() {
			return {
				orders:{
					
				}
			}
		},
		created() {
			const th = this;
			axios.get('/ex/waybill/getCount')
				.then(function(res) {
					th.orders = res.data.data;
				});
		}
	}
</script>
