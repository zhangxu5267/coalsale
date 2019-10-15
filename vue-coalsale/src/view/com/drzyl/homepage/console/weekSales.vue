<template>
  <Card v-height="480" >
    <div slot="title">
      <Avatar icon="ios-people" size="small" v-color="'#faad14'" v-bg-color="'#fffbe6'"/>
      <span class="ivu-pl-8">周销量</span>
    </div>
    <div ref="echart" style="height:400px;" ></div>
  </Card>
</template>

<script>
import echarts from "echarts";
import macarons from 'echarts/theme/macarons.js'

export default {
  methods: {
    initEchart() {
      let chart = echarts.init(this.$refs.echart,'macarons');
      let option = {
        toolbox: {
          right: 20,
          feature: {
            saveAsImage: {}
          }
        },
        legend: {
          data: ["府谷分公司", "榆林销售公司", "韩城分公司", "榆中销售公司", "黄陵分公司", "蒲白分公司", "铜川分公司", "彬长分公司", "西南办事处", "华中办事处", "郑州办事处"]
        },
        xAxis: {
          type: 'category',
          data: ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"]
        },
        tooltip: {
            trigger: 'axis'
        },
        yAxis: {gridIndex: 0},
        grid: {top: '22%'},
        series: [
          {
            name: "府谷分公司",
            data: [1728, 2578, 3768, 4982, 5665, 6489, 3288],
            type: 'bar',
            tooltip: true,
            smooth: true,
            symbol: 'none',
          },
          {
            name: "榆林销售公司",
            data: [3726, 1578, 6768, 7922, 8665, 9909, 5098],
            type: 'bar',
            tooltip: true,
            smooth: true,
            symbol: 'none',
          },
          {
            name: "韩城分公司",
            data: [2726, 6578, 9768, 2922, 3665, 8909, 4098],
            type: 'bar',
            tooltip: true,
            smooth: true,
            symbol: 'none',
          },
          {
            name: "榆中销售公司",
            data: [9126, 4378, 6768, 4222, 9765, 5949, 3078],
            type: 'bar',
            tooltip: true,
            smooth: true,
            symbol: 'none',
          },
          {
            name: "黄陵分公司",
            data: [9426, 4678, 6768, 14922, 2665, 15909, 8098],
            type: 'bar',
            tooltip: true,
            smooth: true,
            symbol: 'none',
          },
          {
            name: "蒲白分公司",
            data: [19726, 4578, 6768, 4922, 9665, 5909, 3098],
            type: 'bar',
            tooltip: true,
            smooth: true,
            symbol: 'none',
          },
          {
            name: "铜川分公司",
            data: [9726, 4578, 6768, 4922, 9665, 5909, 3098],
            type: 'bar',
            tooltip: true,
            smooth: true,
            symbol: 'none',
          },
          {
            name: "彬长分公司",
            data: [9726, 4578, 6768, 4922, 9665, 5909, 3098],
            type: 'bar',
            tooltip: true,
            smooth: true,
            symbol: 'none',
          },
          {
            name: "西南办事处",
            data: [9726, 4578, 6768, 4922, 9665, 5909, 3098],
            type: 'bar',
            tooltip: true,
            smooth: true,
            symbol: 'none',
          },
          {
            name: "华中办事处",
            data: [9726, 4578, 6768, 4922, 9665, 5909, 3098],
            type: 'bar',
            tooltip: true,
            smooth: true,
            symbol: 'none',
          },
          {
            name: "郑州办事处",
            data: [9226, 3578, 5768, 1922, 5465, 3209, 1098],
            type: 'bar',
            tooltip: true,
            smooth: true,
            symbol: 'none',
        }
        ],
      };
      chart.setOption(option);
      chart.on('updateAxisPointer', function (event) {
        var xAxisInfo = event.axesInfo[0];
        if (xAxisInfo) {
            var dimension = xAxisInfo.value + 1;
            chart.setOption({
                series: {
                    id: 'pie',
                    type: 'line',
                    label: {
                        formatter: '{b}: {@[' + dimension + ']} ({d}%)'
                    },
                    encode: {
                        value: dimension,
                        tooltip: dimension
                    }
                }
            });
        }
    });
    }
  },
  mounted () {
    this.initEchart()
  }

}
</script>