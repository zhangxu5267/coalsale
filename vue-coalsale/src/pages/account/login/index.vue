<template>
  <div class="page-account">
    <div v-if="showI18n" class="page-account-header">
      <i-header-i18n />
    </div>
    <div class="page-account-container" style="margin-top:66px">
      <div class="page-account-top">
        <div class="page-account-top-logo">
          <img src="@/assets/images/smyxjt_logo_02.png" alt="logo">
        </div>
        <div class="page-account-top-desc">
          <h2>陕西省煤炭运销（集团）有限责任公司</h2>
          <h6>Shaanxi Coal Selling and Transpotation (group) corporation</h6>
        </div>
      </div>
      <Row type="flex" justify="center">
        <Col class="login-input" span="12">
          <a :class="{ 'login-tab': !accountOnShow, 'login-tab-on': accountOnShow }" @click="accountOn()">账号密码登录</a>
          <Divider class="under-line" v-if="accountUnderLineShow" />
        </Col>
        <Col class="login-input" span="12">
          <a :class="{ 'login-tab': !phoneOnShow, 'login-tab-on': phoneOnShow }" @click="phoneOn()">手机号登录</a>
          <Divider class="under-line" v-if="phoneUnderLineShow" />
        </Col>
      </Row>
      <Row type="flex" justify="center" v-show="accountLoginShow">
        <Col class="login-input" span="24">
          <Form class="pro-margin-top-12" ref="accountForm" :model="account" :rules="accountFormValidate" @keydown.enter.native="accountLogin">
            <FormItem prop="account">
              <Input size="large" v-model="account.account" placeholder="账号">
                <Icon type="ios-contact-outline" slot="prefix"></Icon>
              </Input>
            </FormItem>
            <FormItem prop="password">
              <Input size="large" v-model="account.password" prefix="ios-lock-outline" type="password" password placeholder="密码"/>
            </FormItem>
            <FormItem>
              <Button type="primary" size="large" long @click="accountLogin()">登录</Button>
            </FormItem>
            <a class="pro-float-left" @click="xxx()">忘记密码</a>
            <a class="pro-float-right" @click="xxx()">注册账号</a>
          </Form>
        </Col>
      </Row>
      <Row type="flex" justify="center" v-show="phoneLoginShow">
        <Col class="login-input" span="24">
            <Login ref="login" @on-submit="handlePhoneSubmit">
                <Mobile name="mobile" />
                <Captcha name="captcha" :field="['mobile']" enter-to-submit @on-get-captcha="handleGetCaptcha" />
                <Submit />
            </Login>
        </Col>
      </Row>
      <!-- <Login @on-submit="handleSubmit">
        <UserName name="username" value="admin" />
        <Password name="password" value="admin" enter-to-submit />
        <div class="page-account-auto-login">
          <Checkbox v-model="autoLogin" size="large">自动登录</Checkbox>
          <a href="">忘记密码</a>
        </div>
        <Submit>登录</Submit>
      </Login> -->
      <!-- <div class="page-account-other">
        <span>其它登录方式</span>
        <img src="@/assets/svg/icon-social-wechat.svg" alt="wechat">
        <img src="@/assets/svg/icon-social-qq.svg" alt="qq">
        <img src="@/assets/svg/icon-social-weibo.svg" alt="weibo">
        <router-link class="page-account-register" :to="{ name: 'register' }">{{ $t('page.login.signup') }}</router-link>
      </div> -->
    </div>
    <i-copyright />
  </div>
</template>
<script>
import iCopyright from '@/components/copyright';
import { mapActions } from 'vuex';
import mixins from '../mixins';
import LoginInfoParam from '@/view/com/drzyl/sign/business/login/LoginInfoParam'
import util from '@/libs/util';
import ToolUtil from '@/tool/ToolUtil'

export default {
  mixins: [ mixins ],
  components: { iCopyright },
  data () {
    return {
      accountUnderLineShow: true,
      phoneUnderLineShow: false,
      accountOnShow: true,
      phoneOnShow: false,
      account: new LoginInfoParam(),
      accountFormValidate: {
        account: [
          { required: true, message: '账号不能为空', trigger: 'blur' }
        ],
        password: [
          { required: true, message: '密码不能为空', trigger: 'blur' }
        ]
      },
      eyeIconColor: '#515a6e',
      accountLoginShow: true,
      phoneLoginShow: false,
      phone: new LoginInfoParam(),
      phoneFormValidate: {
        mobilePhoneNumber: [
          { required: true, message: '手机号不能为空', trigger: 'blur' }
        ],
        verificationCode: [
          { required: true, message: '验证码不能为空', trigger: 'blur' }
        ]
      },
      autoLogin: true,
      validatePhone: function(rule, value, callback) {
          if (!value) {
              return callback(new Error('手机号不能为空'));
          } else if (!/^1[34578]\d{9}$/.test(value)) {
              callback('手机号格式不正确');
          } else {
              callback();
          }   
      }
    }
  },
  methods: {
    // ...mapActions('admin/account', [
    //   'logincs'
    // ]),
    ...mapActions('signinStore', [
      'login',
      'sendVerificationCode'
    ]),
    // 账号密码登录
    accountLogin () {
      this.$refs.accountForm.validate((valid) => {
        if (valid) {
          let loginInfoParam = new LoginInfoParam()
          loginInfoParam.loginKey = 'Browser'
          loginInfoParam.account = this.account.account
          loginInfoParam.password = this.account.password
          this.login(loginInfoParam).then(async res => {
            if (res.data.success) {
              util.cookies.set('uuid', res.data.data[0].accountId)
              util.cookies.set('token', res.data.data[0].token, { expires: new Date(res.data.data[0].cookiesExpireTimes) })
              util.cookies.set('aeskey', ToolUtil.decodeRSAByPrivateKey(res.data.data[0].aesKey, ToolUtil.privateKey))
              await this.$store.dispatch('admin/user/set', { name: res.data.data[0].name, avatar: res.data.data[0].avatar, access: res.data.data[0].accessList }, { root: true })
              await this.$store.dispatch('admin/account/load')
              // this.$Message.success({ content: res.data.data[0].msg, duration: 3 })
              this.$router.replace(this.$route.query.redirect || '/');
            } else {
              this.$Message.error({ content: res.data.msg, duration: 6 })
            }
          }).catch(result => {
            this.$Message.error({ content: result.response.statusText, duration: 6 })
          })
        }
      })
    },
    /**
     * @description 登录
     * 表单校验已有 iView Pro 自动完成，如有需要修改，请阅读 iView Pro 文档
     */
    // handleSubmit (valid, values) {
    //   if (valid) {
    //     const { username, password } = values;
    //     this.logincs({
    //       username,
    //       password
    //     })
    //       .then(() => {
    //         // 重定向对象不存在则返回顶层路径
    //         this.$router.replace(this.$route.query.redirect || '/');
    //     });
    //   }
    // },
    accountOn () {
      this.accountUnderLineShow = true
      this.phoneUnderLineShow = false
      this.accountOnShow = true
      this.phoneOnShow = false
      this.accountLoginShow = true
      this.phoneLoginShow = false
      this.$refs.accountForm.resetFields()
      // this.$refs.phoneForm.resetFields()
    },
    phoneOn () {
      this.phoneUnderLineShow = true
      this.accountUnderLineShow = false
      this.phoneOnShow = true
      this.accountOnShow = false
      this.phoneLoginShow = true
      this.accountLoginShow = false
      // this.$refs.phoneForm.resetFields()
      this.$refs.accountForm.resetFields()
    },
    /**
     * 登录
     */
    handlePhoneSubmit (valid, { mobile, captcha }) {
      if (valid) {
          let loginInfoParam = new LoginInfoParam()
          loginInfoParam.loginKey = 'sms'
          loginInfoParam.mobilePhoneNumber = mobile
          loginInfoParam.verificationCode = captcha
          this.login(loginInfoParam).then(async res => {
            if (res.data.success) {
              util.cookies.set('uuid', res.data.data[0].accountId)
              util.cookies.set('token', res.data.data[0].token, { expires: new Date(res.data.data[0].cookiesExpireTimes) })
              util.cookies.set('aeskey', ToolUtil.decodeRSAByPrivateKey(res.data.data[0].aesKey, ToolUtil.privateKey))
              await this.$store.dispatch('admin/user/set', { name: res.data.data[0].name, avatar: res.data.data[0].avatar, access: res.data.data[0].accessList }, { root: true })
              await this.$store.dispatch('admin/account/load')
              // this.$Message.success({ content: res.data.data[0].msg, duration: 3 })
              this.$router.replace(this.$route.query.redirect || '/');
            } else {
              this.$Message.error({ content: res.data.msg, duration: 6 })
            }
          }).catch(result => {
            this.$Message.error({ content: result.response.statusText, duration: 6 })
          })
      }
    },
    /**
     * @description 获取验证码
     * */
    handleGetCaptcha () {
        let loginInfoParam = new LoginInfoParam()
        loginInfoParam.mobilePhoneNumber = this.$refs.login.formValidate.mobile
        this.sendVerificationCode(loginInfoParam).then(async res => {
          
        }).catch(result => {
          this.$Message.error({ content: result.response.statusText, duration: 6 })
        })
    }
  }
};
</script>
