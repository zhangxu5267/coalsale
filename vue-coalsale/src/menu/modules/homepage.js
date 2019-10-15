export default {
  path: '/homepage',
  title: '主页',
  header: 'home',
  icon: 'ios-home',
  auth: ['homepage'],
  children: [
      {
          path: `/homepage/console`,
          title: '主控台',
          auth: ['homepage']
      },
      {
          path: `/homepage/workplace`,
          title: '工作台',
          auth: ['homepage']
      }
  ]
}
