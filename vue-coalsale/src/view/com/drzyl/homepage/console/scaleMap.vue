<template>
  <Card :bordered="true" v-height="480" >
    <div slot="title">
      <Avatar icon="ios-people" size="small" v-color="'#faad14'" v-bg-color="'#fffbe6'"/>
      <span class="ivu-pl-8">模拟数据面积</span>
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
      let base = +new Date(2018, 10, 9);
      let oneDay = 24 * 3600 * 1000;
      let date = [];
      let data = [Math.random() * 300];
      for (let i = 1; i < 365; i++) {
          let now = new Date(base += oneDay);
          date.push([now.getFullYear(), now.getMonth() + 1, now.getDate()].join('/'));
          data.push(Math.round((Math.random() - 0.5) * 20 + data[i - 1]));
      }
      let chart = echarts.init(this.$refs.echart,'macarons');
      let option = {
          tooltip: {
              trigger: 'axis',
              position: function (pt) {
                  return [pt[0], '10%'];
              }
          },
          title: {
              left: 'center',
              text: '大数据量面积图',
          },
          toolbox: {
              feature: {
                  dataZoom: {
                      yAxisIndex: 'none'
                  },
                  restore: {},
                  saveAsImage: {}
              }
          },
          xAxis: {
              type: 'category',
              boundaryGap: false,
              data: date
          },
          yAxis: {
              type: 'value',
              boundaryGap: [0, '100%']
          },
          dataZoom: [{
              type: 'inside',
              start: 0,
              end: 10
          }, {
              start: 0,
              end: 10,
              handleIcon: 'M10.7,11.9v-1.3H9.3v1.3c-4.9,0.3-8.8,4.4-8.8,9.4c0,5,3.9,9.1,8.8,9.4v1.3h1.3v-1.3c4.9-0.3,8.8-4.4,8.8-9.4C19.5,16.3,15.6,12.2,10.7,11.9z M13.3,24.4H6.7V23h6.6V24.4z M13.3,19.6H6.7v-1.4h6.6V19.6z',
              handleSize: '80%',
              handleStyle: {
                  color: '#fff',
                  shadowBlur: 3,
                  shadowColor: 'rgba(0, 0, 0, 0.6)',
                  shadowOffsetX: 2,
                  shadowOffsetY: 2
              }
          }],
          series: [
              {
                  name:'销量',
                  type:'line',
                  smooth:true,
                  symbol: 'none',
                  sampling: 'average',
                  itemStyle: {
                      color: 'rgb(255, 70, 131)'
                  },
                  areaStyle: {
                      color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                          offset: 0,
                          color: 'rgb(255, 158, 68)'
                      }, {
                          offset: 1,
                          color: 'rgb(255, 70, 131)'
                      }])
                  },
                  data: data
              }
          ]
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