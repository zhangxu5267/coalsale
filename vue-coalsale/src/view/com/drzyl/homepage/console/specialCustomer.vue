<template>
    <Row :gutter="24">
        <Col :xl="24" :lg="24" :md="24" :sm="24" :xs="24">
            <Card :bordered="true" v-height="480">
                <p slot="title">
                    <Icon type="md-stats" />
                    <span>特殊客户销量（单位：万吨）</span>
                </p>
                <div ref="specEchart" style="height:400px;" ></div>
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
                
            }
        },
        methods: {
            initSpecEchart() {
                let chart = echarts.init(this.$refs.specEchart,'macarons');
                let specOption = {
                    tooltip : {
                        trigger: 'axis',
                        axisPointer: {
                            type: 'cross',
                            label: {
                                backgroundColor: '#6a7985'
                            }
                        }
                    },
                    legend: {
                        data:['A公司','B公司','C公司','D公司','E公司']
                    },
                    toolbox: {
                        feature: {
                            saveAsImage: {}
                        }
                    },
                    grid: {
                        left: '3%',
                        right: '10%',
                        containLabel: true
                    },
                    xAxis : [
                        {
                            type : 'category',
                            boundaryGap : false,
                            data : ["十月", "十一月", "十二月", "一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月"]
                        }
                    ],
                    yAxis : [
                        {
                            type : 'value'
                        }
                    ],
                    series : [
                        {
                            name:'A公司',
                            type:'line',
                            stack: '总量',
                            areaStyle: {},
                            data:[1728, 2578, 3768, 4982, 5665, 6489, 3288,3422, 6753, 663, 8162, 7145]
                        },
                        {
                            name:'B公司',
                            type:'line',
                            stack: '总量',
                            areaStyle: {},
                            data:[3726, 1578, 6768, 7922, 8665, 9909, 5098, 4222, 3783, 2463, 1162, 3095]
                        },
                        {
                            name:'C公司',
                            type:'line',
                            stack: '总量',
                            areaStyle: {},
                            data:[2726, 6578, 9768, 2922, 3665, 8909, 4098, 7222, 6783, 7763, 6162, 6295]
                        },
                        {
                            name:'D公司',
                            type:'line',
                            stack: '总量',
                            areaStyle: {normal: {}},
                            data:[9126, 4378, 6768, 4222, 9765, 5949, 3078, 14212, 6773, 7453, 6152, 6085]
                        },
                        {
                            name:'E公司',
                            type:'line',
                            stack: '总量',
                            label: {
                                normal: {
                                    show: true,
                                    position: 'top'
                                }
                            },
                            areaStyle: {normal: {}},
                            data:[9426, 4678, 6768, 14922, 2665, 15909, 8098, 4222, 8783, 6463, 4162, 2095]
                        }
                    ]
                };  
                chart.setOption(specOption);
            },
            handleResize () {
                if (this.orderChart) this.orderChart.resize();
            }
        },
        mounted () {
            this.initSpecEchart();
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