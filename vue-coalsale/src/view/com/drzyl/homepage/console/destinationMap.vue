<template>
  <Row :gutter="24">
      <Col :xl="24" :lg="24" :md="24" :sm="24" :xs="24" style="padding: 0" v-height="600">
          <Card :bordered="true">
            <div class="echarts">
              <div :style="{height:'600px',width:'95%'}" ref="myEchart"></div>
            </div>
          </Card>
      </Col>
  </Row>
</template>

<script>
  import echarts from "echarts";
  import 'echarts/map/js/china.js' // 引入中国地图数据
  export default {
    // props: ["renderData"],
    data() {
      return {
        chart: null
      };
    },
    mounted() {
      this.initEchartMap();
    },
    beforeDestroy() {
      if (!this.chart) {
        return;
      }
      this.chart.dispose();
      this.chart = null;
    },
    methods: {
      initEchartMap() {
        //console.log(this.renderData)
        //这里我们用固定的数据，真正使用时，用父组件传递来的数据替换series即可
        let myChart = echarts.init(this.$refs.myEchart); 
        window.onresize = myChart.resize;
        myChart.setOption({
          // backgroundColor: "#0b1225",
          title: {
                text: '陕煤运销',
                left: 'center',
                textStyle: {
                    color: '#fff'
                }
            },
          tooltip : {
                trigger: 'item'
            },
          dataRange: {
            show: false,
            min: 0,
            max: 1000,
            text: ['High', 'Low'],
            realtime: true,
            calculable: true,
            color: ['orangered', 'yellow', 'lightskyblue']
          },
          visualMap : {
                show : true,
                min : 0,
                max : 255,
                calculable : true,
                inRange : {
                    color : ['aqua', 'lime', 'yellow', 'orange', '#ff3333']
                },
                textStyle : {
                    color : '#12223b'
                }
            }, 
          geo: { // 这个是重点配置区
            map: 'china', // 表示中国地图
            roam: true,
            layoutCenter : ['50%', '50%'],
			      layoutSize : "130%",
            label: {
              normal: {
                show: true, // 是否显示对应地名
                textStyle: {
                  // color: 'rgba(0,0,0,0.4)'
                  color: '#fff'
                }
              },
            },
            itemStyle: {
              normal: {
                areaColor: '#37376e',
                borderColor: 'rgba(0, 0, 0, 0.2)'
              },
              emphasis: {
                areaColor: null,
                shadowOffsetX: 0,
                shadowOffsetY: 0,
                shadowBlur: 20,
                borderWidth: 0,
                // shadowColor: 'rgba(0, 0, 0, 0.5)'
              }
            }
          },
          series: [
              {
                    "type": "lines", 
                    "zlevel": 2, 
                    "effect": {
                        "show": true, 
                        "period": 4, 
                        "trailLength": 0.02, 
                        "symbol": "arrow", 
                        "symbolSize": 5
                    }, 
                    "lineStyle": {
                        "normal": {
                            "width": 1, 
                            "opacity": 0.6, 
                            "curveness": 0.2
                        }
                    }, 
                    "tooltip": {
                        "trigger": "item"
                    }, 
                    "data": [
                        {
                            "fromName": "陕西", 
                            "toName": "江苏", 
                            "value": 19, 
                            "coords": [
                                [
                                    108.93425, 
                                    34.23053
                                ],
                                [
                                    "119.68", 
                                    "33.199"
                                ]
                            ]
                        }, 
                        {
                            "fromName": "陕西", 
                            "toName": "兰州", 
                            "value": 19, 
                            "coords": [
                                [
                                    108.93425, 
                                    34.23053
                                ],
                                [
                                    "103.71878", 
                                    "36.10396"
                                ]
                            ]
                        }, 
                        {
                            "fromName": "陕西", 
                            "toName": "张掖", 
                            "value": 19, 
                            "coords": [
                                [
                                    108.93425, 
                                    34.23053
                                ],
                                [
                                    "100.47801", 
                                    "38.92967", 
                                ]
                            ]
                        }, 
                        {
                            "fromName": "陕西", 
                            "toName": "安徽", 
                            "value": 17, 
                            "coords": [
                                [
                                    108.93425, 
                                    34.23053
                                ],
                                [
                                    "117.229", 
                                    "31.917"
                                ], 
                            ]
                        }, 
                        {
                            "fromName": "陕西", 
                            "toName": "上海", 
                            "value": 25, 
                            "coords": [
                                [
                                    108.93425, 
                                    34.23053
                                ],
                                [
                                    "121.465", 
                                    "31.289"
                                ], 
                            ]
                        }, 
                        {
                            "fromName": "陕西", 
                            "toName": "湖北", 
                            "value": 31, 
                            "coords": [
                                [
                                    108.93425, 
                                    34.23053
                                ],
                                 [
                                    "114.39", 
                                    "30.663"
                                ], 
                            ]
                        }, 
                        {
                            "fromName": "陕西", 
                            "toName": "福建", 
                            "value": 12, 
                            "coords": [
                                [
                                    108.93425, 
                                    34.23053
                                ],
                                [
                                    "119.454", 
                                    "25.922"
                                ], 
                            ]
                        }, 
                        {
                            "fromName": "陕西", 
                            "toName": "浙江", 
                            "value": 19, 
                            "coords": [  
                                [
                                    108.93425, 
                                    34.23053
                                ],
                                [
                                    "119.531", 
                                    "29.877"
                                ], 
                            ]
                        }, 
                        {
                            "fromName": "陕西", 
                            "toName": "河南", 
                            "value": 15, 
                            "coords": [
                                [
                                    108.93425, 
                                    34.23053
                                ],
                                [
                                    "113.467", 
                                    "34.623"
                                ], 
                            ]
                        }, 
                        {
                            "fromName": "陕西", 
                            "toName": "山东", 
                            "value": 12, 
                            "coords": [
                                [
                                    108.93425, 
                                    34.23053
                                ],
                                [
                                    "116.972", 
                                    "36.737"
                                ], 
                            ]
                        }, 
                        {
                            "fromName": "陕西", 
                            "toName": "广东", 
                            "value": 12, 
                            "coords": [
                                [
                                    108.93425, 
                                    34.23053
                                ],
                                [
                                    "113.511", 
                                    "23.22"
                                ], 
                            ]
                        }, 
                        {
                            "fromName": "陕西", 
                            "toName": "四川", 
                            "value": 10, 
                            "coords": [
                                [
                                    108.93425, 
                                    34.23053
                                ],
                                [
                                    "103.953", 
                                    "30.762"
                                ], 
                            ]
                        }, 
                        {
                            "fromName": "陕西", 
                            "toName": "江西", 
                            "value": 9, 
                            "coords": [
                                [
                                    108.93425, 
                                    34.23053
                                ],
                                [
                                    "116.005", 
                                    "28.663"
                                ], 
                            ]
                        }, 
                        {
                            "fromName": "陕西", 
                            "toName": "重庆", 
                            "value": 8, 
                            "coords": [
                                [
                                    108.93425, 
                                    34.23053
                                ],
                                [
                                    "106.438", 
                                    "29.581"
                                ], 
                            ]
                        }, 
                        {
                            "fromName": "陕西", 
                            "toName": "贵州", 
                            "value": 4, 
                            "coords": [
                                [
                                    108.93425, 
                                    34.23053
                                ],
                                [
                                    "106.71", 
                                    "26.564"
                                ], 
                            ]
                        }, 
                        {
                            "fromName": "陕西", 
                            "toName": "山西", 
                            "value": 4, 
                            "coords": [
                                [
                                    108.93425, 
                                    34.23053
                                ],
                                [
                                    "112.593", 
                                    "37.867"
                                ], 
                            ]
                        }, 
                        {
                            "fromName": "陕西", 
                            "toName": "湖南", 
                            "value": 4, 
                            "coords": [
                                [
                                    108.93425, 
                                    34.23053
                                ],
                                [
                                    "113.082", 
                                    "28.257"
                                ], 
                            ]
                        }, 
                        {
                            "fromName": "陕西", 
                            "toName": "吉林", 
                            "value": 3, 
                            "coords": [
                                [
                                    108.93425, 
                                    34.23053
                                ],
                                [
                                    "125.815", 
                                    "44.258"
                                ], 
                            ]
                        }, 
                        {
                            "fromName": "陕西", 
                            "toName": "广西", 
                            "value": 2, 
                            "coords": [
                                [
                                    108.93425, 
                                    34.23053
                                ],
                                [
                                    "107.88", 
                                    "22.863"
                                ], 
                            ]
                        }, 
                    ]
              },
              {     
                    "name": "收货地址",
                    "type": "effectScatter", 
                    "coordinateSystem": "geo", 
                    "zlevel": 2, 
                    "rippleEffect": {
                        "period": 4, 
                        "brushType": "stroke", 
                        "scale": 4
                    }, 
                    "tooltip": {
                        "trigger": "item"
                    }, 
                    "label": {
                        "normal": {
                            "show": true, 
                            "position": "left", 
                            "offset": [
                                -5, 
                                5
                            ], 
                            "formatter": "{b}"
                        }, 
                        "emphasis": {
                            "show": true
                        }
                    }, 
                    "hoverAnimation": true,
                    "symbol": "circle", 
                    "symbolSize": 5, 
                    "itemStyle": {
                        "normal": {
                            "show": false, 
                            "color": "#f00"
                        }
                    }, 
                    "data": [
                        {
                            "value": [
                                "119.68", 
                                "33.199", 
                                19
                            ]
                        }, 
                        {
                            "value": [
                                "103.71878", 
                                "36.10396", 
                                19
                            ]
                        }, 
                        {
                            "value": [
                                "100.47801", 
                                "38.92967", 
                                19
                            ]
                        }, 
                        {
                            "value": [
                                "117.229", 
                                "31.917", 
                                17
                            ]
                        }, 
                        {
                            "value": [
                                "121.465", 
                                "31.289", 
                                25
                            ]
                        }, 
                        {
                            "value": [
                                "114.39", 
                                "30.663", 
                                31
                            ]
                        }, 
                        {
                            "value": [
                                "119.454", 
                                "25.922", 
                                22
                            ]
                        }, 
                        {
                            "value": [
                                "119.531", 
                                "29.877", 
                                19
                            ]
                        }, 
                        {
                            "value": [
                                "116.972", 
                                "36.737", 
                                12
                            ]
                        }, 
                        {
                            "value": [
                                "103.953", 
                                "30.762", 
                                10
                            ]
                        }, 
                        {
                            "value": [
                                "116.005", 
                                "28.663", 
                                9
                            ]
                        }, 
                        {
                            "value": [
                                "106.71", 
                                "26.564", 
                                4
                            ]
                        }, 
                        {
                            "value": [
                                "113.082", 
                                "28.257", 
                                4
                            ]
                        }, 
                        {
                            "value": [
                                "107.88", 
                                "22.863", 
                                2
                            ]
                        }, 
                    ]
              },
              {
                "name": "发送地址",
                "type": "scatter", 
                "coordinateSystem": "geo", 
                "zlevel": 2, 
                "tooltip": {
                    "trigger": "item"
                }, 
                "label": {
                    "normal": {
                        "show": true, 
                        "position": "right", 
                        "color": "#00ffff", 
                        "formatter": "{b}", 
                        "textStyle": {
                            "color": "#00ffff"
                        }
                    }, 
                    "emphasis": {
                        "show": true
                    }
                }, 
                "symbol": "circle", 
                "symbolSize": 20, 
                "itemStyle": {
                    "normal": {
                        "show": true, 
                        "color": "#EE0000"
                    }
                }, 
                "data": [
                    {
                        // "name": "陕西", 
                        "value": [
                            108.93425, 
                            34.23053
                        ]
                    }
                ]
            }
          ]
        })
      }
    }
  }
</script>