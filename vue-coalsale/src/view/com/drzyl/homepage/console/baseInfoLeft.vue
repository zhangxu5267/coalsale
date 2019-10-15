<template>
    <Row :gutter="24">
        <Col :xl="12" :lg="24" :md="24" :sm="24" :xs="24" class="ivu-mb">
            <Card :bordered="true" :padding="6" v-height="400">
                <p slot="title">
                    <Icon type="md-stats" />
                    <span>当月销量（单位：万吨）</span>
                </p>
                <div ref="salesEchart" style="height:400px;" ></div>
            </Card>
        </Col>
        <Col :xl="12" :lg="24" :md="24" :sm="24" :xs="24" class="ivu-mb">
            <Card :bordered="true" :padding="6" v-height="400">
                <p slot="title">
                    <Icon type="ios-archive" />
                    <span>当前库存（单位：万吨）</span>
                </p>
                <div ref="inventoryEchart" style="height:400px;" ></div>
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
                    grid: {
                        left: '3%',
                        right: '4%',
                        bottom: '6%',
                        containLabel: true
                    },
                    tooltip: {
                        trigger: 'item',
                        formatter: "{a} <br/>{b}: {c} ({d}%)"
                    },
                    legend: {
                        type: 'scroll',
                        orient: 'horizontal',
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
                    grid: {
                        // left: '3%',
                        right: '5%',
                        bottom: '6%',
                        containLabel: true
                    },
                    tooltip: {
                        trigger: 'item',
                        formatter: "{a} <br/>{b}: {c} ({d}%)"
                    },
                    legend: {
                        type: 'scroll',
                        orient: 'horizontal',
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
            this.initSalesEchart();
            this.inventoryEchart();
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