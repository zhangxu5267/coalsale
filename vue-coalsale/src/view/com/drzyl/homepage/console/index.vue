<template>
  <div>
    <Card>
      <Row :gutter="24" class="ivu-mt">
        <Col :xl="12" :lg="24" :md="24" :sm="24" :xs="24" class="ivu-mb">
          <base-info-left ref="baseInfoLeft" />
        </Col>
        <!-- <Col :xl="12" :lg="24" :md="24" :sm="24" :xs="24" class="ivu-mb">
          <areaMap />
        </Col> -->
        <Col :xl="12" :lg="24" :md="24" :sm="24" :xs="24" class="ivu-mb">
          <base-info-right ref="baseInfoRight" />
        </Col>
      </Row>
      <Row :gutter="24" class="ivu-mt">
        <Col :xl="24" :lg="24" :md="24" :sm="24" :xs="24" class="ivu-mb">
          <ChinaMap />
        </Col>
      </Row>
      <Row :gutter="24" class="ivu-mt">
        <Col :xl="16" :lg="24" :md="24" :sm="24" :xs="24" class="ivu-mb">
          <monthSales />
        </Col>
        <Col :xl="8" :lg="24" :md="24" :sm="24" :xs="24" class="ivu-mb">
          <weekSales/>
        </Col>
      </Row>
      <Row :gutter="24" class="ivu-mt">
        <Col :xl="12" :lg="24" :md="24" :sm="24" :xs="24" class="ivu-mb">
          <specialCustomer />
        </Col>
        <Col :xl="12" :lg="24" :md="24" :sm="24" :xs="24" class="ivu-mb">
          <scaleMap />
        </Col>
      </Row>
      <!-- <Row :gutter="24" class="ivu-mt">
        <Col :xl="24" :lg="24" :md="24" :sm="24" :xs="24" class="ivu-mb">
          <flightMap />
        </Col>
      </Row> -->
    </Card>
  </div>
</template>

<script>
import baseInfoLeft from "./baseInfoLeft";
import baseInfoRight from "./baseInfoRight";
import monthSales from "./monthSales";
import weekSales from "./weekSales";
import ChinaMap from "./destinationMap";
import areaMap from "./areaMap";
import specialCustomer from "./specialCustomer";
import scaleMap from "./scaleMap";
import flightMap from "./flightMap";

export default {
  name: "dashboard-console",
  components: {
    baseInfoLeft,
    baseInfoRight,
    monthSales,
    weekSales,
    ChinaMap,
    areaMap,
    specialCustomer,
    scaleMap,
    flightMap
  },
  data() {
    return {
      
    };
  },
  methods: {
    handleResize() {
      this.$refs.baseInfoLeft.handleResize();
      this.$refs.baseInfoRight.handleResize();
      this.$refs.monthSales.handleResize();
      this.$refs.weekSales.handleResize();
    },
    
  },
  mounted() {

  }
};
</script>
<style lang="less">

</style>
