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
import 'echarts/map/js/china.js'
import macarons from 'echarts/theme/macarons.js'
import flights from './flights.json'

export default {
  methods: {
    initEchart() {
        
      let chart = echarts.init(this.$refs.echart,'macarons');
      
      let uploadedDataURL = flights;
      chart.showLoading();
      var $ = {
            getJSON: function(url, params, callbackFuncName, callback){
                var paramsUrl ="",
                    jsonp = this.getQueryString(url)[callbackFuncName];
                for(var key in params){
                    paramsUrl+="&"+key+"="+encodeURIComponent(params[key]);
                }
                url+=paramsUrl;
                window[jsonp] = function(data) {
                    window[jsonp] = undefined;
                    try {
                        delete window[jsonp];
                    } catch(e) {}

                    if (head) {
                        head.removeChild(script);
                    }
                    callback(data);
                };

                var head = document.getElementsByTagName('head')[0];
                var script = document.createElement('script');
                script.charset = "UTF-8";
                script.src = url;
                head.appendChild(script);
                return true;
            },
            getQueryString: function(url) {
                var result = {}, queryString = (url && url.indexOf("?")!=-1 && url.split("?")[1]) || location.search.substring(1),
                    re = /([^&=]+)=([^&]*)/g, m;
                while (m = re.exec(queryString)) {
                    result[decodeURIComponent(m[1])] = decodeURIComponent(m[2]);
                }
                return result;
            }
        };
      $.getJSON(uploadedDataURL, function(data) {
          chart.hideLoading();
          function getAirportCoord(idx) {
              return [data.airports[idx][3], data.airports[idx][4]];
          }
          var routes = data.routes.map(function (airline) {
              return [
                  getAirportCoord(airline[1]),
                  getAirportCoord(airline[2])
              ];
          });
          let option = {
              geo3D: {
                  map: 'china',
                  shading: 'realistic',
                  silent: true,
                  environment: '#333',
                  realisticMaterial: {
                      roughness: 0.8,
                      metalness: 0
                  },
                  postEffect: {
                      enable: true
                  },
                  groundPlane: {
                      show: false
                  },
                  light: {
                      main: {
                          intensity: 1,
                          alpha: 30
                      },
                      ambient: {
                          intensity: 0
                      }
                  },
                  viewControl: {
                      distance: 70,
                      alpha: 89,

                      panMouseButton: 'left',
                      rotateMouseButton: 'right'
                  },

                  itemStyle: {
                      areaColor: '#000'
                  },

                  regionHeight: 0.5
              },
              series: [{
                  type: 'lines3D',

                  coordinateSystem: 'geo3D',

                  effect: {
                      show: true,
                      trailWidth: 1,
                      trailOpacity: 0.5,
                      trailLength: 0.2,
                      constantSpeed: 5
                  },

                  blendMode: 'lighter',

                  lineStyle: {
                      width: 0.2,
                      opacity: 0.05
                  },

                  data: routes
              }]
          };
      })
    //   chart.setOption(option),
    //   chart.on('updateAxisPointer', function (event) {
    //       var xAxisInfo = event.axesInfo[0];
    //       if (xAxisInfo) {
    //           var dimension = xAxisInfo.value + 1;
    //           chart.setOption({
    //               series: {
    //                   id: 'pie',
    //                   type: 'line',
    //                   label: {
    //                       formatter: '{b}: {@[' + dimension + ']} ({d}%)'
    //                   },
    //                   encode: {
    //                       value: dimension,
    //                       tooltip: dimension
    //                   }
    //               }
    //           });
    //       }
    //   })
    }
  },
  mounted () {
    this.initEchart()
  }

}
</script>