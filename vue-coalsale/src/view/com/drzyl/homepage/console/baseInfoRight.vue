<template>
    <Row :gutter="24">
        <Col :xl="12" :lg="24" :md="24" :sm="24" :xs="24" class="ivu-mb">
            <Card :bordered="true" :padding="6" v-height="400">
                <p slot="title">
                    <Icon type="md-add-circle" />
                    <span>新增数据</span>
                </p>
                <Card>
                    <strong>新增用户</strong>
                    <CountUp :end="99" :duration="2" v-font="48" />
                    <span v-font="24"> 位</span>
                </Card>
                
                <Card style="margin-top: 8px">
                    <strong>新增合同</strong>
                    <CountUp :end="20" :duration="2" v-font="48" />
                    <span v-font="24"> 份</span>
                </Card>
                <Card style="margin-top: 8px">
                    <strong>发货量</strong>
                    <CountUp :end="300" :duration="2" v-font="48" />
                    <span v-font="24"> 万吨</span>
                </Card>
            </Card>
        </Col>
        <Col :xl="12" :lg="24" :md="24" :sm="24" :xs="24">
            <Card :bordered="true" :padding="0" v-height="400">
                <p slot="title">
                    <Icon type="md-list-box" />
                    <span>商务纠纷</span>
                </p>
                <Row type="flex" justify="center" align="middle" v-for="item in data" :key="item.id" class="branch-form">
                    <Col span="15">
                        <div>
                            <span>{{ item.branch }}</span>
                        </div>
                    </Col>
                    <Col span="4">
                        <Tag color="green" v-if="item.quantity <= 20">{{item.quantity}}</Tag>
                        <Tag color="red" v-if="item.quantity > 20">{{item.quantity}}</Tag>
                    </Col>
                </Row>
            </Card>
        </Col>
    </Row>
</template>
<script>
    import echarts from 'echarts';
    import macarons from 'echarts/theme/macarons.js'

    export default {
        data () {
            return {
                data: [
                    {
                        branch: '府谷分公司',
                        quantity: 33
                    },
                    {
                        branch: '榆林销售公司',
                        quantity: 30
                    },{
                        branch: '韩城分公司',
                        quantity: 27
                    },{
                        branch: '榆中销售公司',
                        quantity: 24
                    },{
                        branch: '黄陵分公司',
                        quantity: 21
                    },{
                        branch: '蒲白分公司',
                        quantity: 18
                    },{
                        branch: '铜川分公司',
                        quantity: 15
                    },{
                        branch: '彬长分公司',
                        quantity: 12
                    },{
                        branch: '西南办事处',
                        quantity: 9
                    },{
                        branch: '华中办事处',
                        quantity: 6
                    },{
                        branch: '郑州办事处',
                        quantity: 3
                    },
                ],
            }
        },
        methods: {
            initSalesEchart() {
                let chart = echarts.init(this.$refs.salesEchart,'macarons');
                let salesOption = {
                    toolbox: {
                        right: 40,
                        feature: {
                            saveAsImage: {}
                        }
                    },
                    // title: {
                    //     text: '单位：（万吨）',
                    // },
                    tooltip: {
                        trigger: 'item',
                        formatter: "{a} <br/>{b}: {c} ({d}%)"
                    },
                    legend: {
                        type: 'scroll',
                        orient: 'vertical',
                        x: 'left',
                        data:['铁销','地销','港销','公转铁']
                    },
                    series : [
                        {
                            name: '销量',
                            type: 'pie',
                            radius: '55%',
                            data:[
                                {value:235, name:'铁销'},
                                {value:274, name:'地销'},
                                {value:310, name:'港销'},
                                {value:310, name:'公转铁'}
                            ]
                        }
                    ]
                };  
                chart.setOption(salesOption);
            },
            inventoryEchart() {
                let chart = echarts.init(this.$refs.inventoryEchart,'macarons');
                let salesOption = {
                    toolbox: {
                        right: 40,
                        feature: {
                            saveAsImage: {}
                        }
                    },
                    tooltip: {
                        trigger: 'item',
                        formatter: "{a} <br/>{b}: {c} ({d}%)"
                    },
                    legend: {
                        type: 'scroll',
                        orient: 'vertical',
                        x: 'left',
                        data:['港口','公转铁']
                    },
                    series : [
                        {
                            name: '库存',
                            type: 'pie',
                            radius: '55%',
                            data:[
                                {value:235, name:'港口'},
                                {value:274, name:'公转铁'}
                            ]
                        }
                    ]
                };  
                chart.setOption(salesOption);
            },
            handleResize () {
                if (this.orderChart) this.orderChart.resize();
            }
        },
        mounted () {
            // this.initSalesEchart();
            // this.inventoryEchart();
        },
    }
</script>
<style lang="less" scoped>
    .dashboard-workplace-todo{
        padding-bottom: 8px;
        &-move{
            cursor: pointer;
            position: relative;
            left: -14px;
            color: #808695;
        }
    }
    .branch-form{
        margin-bottom: 6px!important;
    }
</style>