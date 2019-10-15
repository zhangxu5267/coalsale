<template>
    <Row :gutter="24">
        <Col v-bind="grid" class="ivu-mb">
            <Card :bordered="true" :padding="6" v-height="400">
                <p slot="title">
                    <Icon type="md-stats" />
                    <span>当月销量（单位：万吨）</span>
                </p>
                <div ref="salesEchart" style="height:400px;" ></div>
            </Card>
        </Col>
        <Col v-bind="grid" class="ivu-mb">
            <Card :bordered="true" :padding="6" v-height="400">
                <p slot="title">
                    <Icon type="ios-archive" />
                    <span>当前库存（单位：万吨）</span>
                </p>
                <div ref="inventoryEchart" style="height:400px;" ></div>
            </Card>
        </Col>
        <Col v-bind="grid" class="ivu-mb">
            <Card :bordered="true" :padding="6" v-height="400">
                <p slot="title">
                    <Icon type="md-add-circle" />
                    <span>本月新增数据</span>
                </p>
                <!-- <Tooltip slot="extra" content="指标说明" placement="top">
                    <Icon type="ios-help-circle-outline" />
                </Tooltip> -->
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
    </Row>
</template>
<script>
    import echarts from 'echarts';
    import macarons from 'echarts/theme/macarons.js'

    export default {
        data () {
            return {
                grid: {
                    xl: 8,
                    lg: 12,
                    md: 12,
                    sm: 12,
                    xs: 24
                },
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