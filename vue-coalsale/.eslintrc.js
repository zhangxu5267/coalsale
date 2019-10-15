module.exports = {
  root: true,
  env: {
    node: true
  },
  rules: {
    "semi": [0],
    'indent': 'off',
    'no-console': 'off',
    'no-debugger': process.env.NODE_ENV === 'production' ? 'error' : 'off',
    "parser": "babel-eslint",
    'vue/no-parsing-error': [2, {
      "x-invalid-end-tag": false
    }],
    'no-debugger': process.env.NODE_ENV === 'production' ? 2 : 0
  },
  parserOptions: {
    parser: 'babel-eslint'
  },
  
}