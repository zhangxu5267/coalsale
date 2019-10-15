<template>
  <div>
    <Card>
      <Row :gutter="24" class="ivu-mt">
        <base-info ref="baseInfo" />
      </Row>
      <Row :gutter="24" class="ivu-mt">
        <Col :xl="16" :lg="24" :md="24" :sm="24" :xs="24" class="ivu-mb">
          <monthSales />
        </Col>
        <Col :xl="8" :lg="24" :md="24" :sm="24" :xs="24" class="ivu-mb">
          <!-- <weekSales/> -->
        </Col>
      </Row>
    </Card>
  </div>
</template>

<script>
import baseInfo from "./base-info";
import monthSales from "./monthSales";
import weekSales from "./weekSales";

export default {
  name: "branchConsole",
  components: {
    baseInfo,
    monthSales,
    weekSales
  },
  data() {
    return {
      
    };
  },
  methods: {
    handleResize() {
      this.$refs.baseInfo.handleResize();
      this.$refs.visitChart.handleResize();
      this.$refs.hotSearch.handleResize();
    },
    
  },
  mounted() {

  }
};
</script>
<style lang="less">
.dashboard-console-visit {
  .ivu-radio-group-button .ivu-radio-wrapper {
    border: none !important;
    box-shadow: none !important;
    padding: 0 12px;
  }
  .ivu-radio-group-button .ivu-radio-wrapper:before,
  .ivu-radio-group-button .ivu-radio-wrapper:after {
    display: none;
  }
}
</style>
