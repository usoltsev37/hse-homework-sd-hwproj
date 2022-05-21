module.exports = {
  pages: {
    'student': {
      entry: './src/pages/student/main.js',
      template: 'public/index.html',
      title: 'Student Page',
      chunks: [ 'chunk-vendors', 'chunk-common', 'student' ]
    },
    'teacher': {
      entry: './src/pages/teacher/main.js',
      template: 'public/index.html',
      title: 'Teacher Page',
      chunks: [ 'chunk-vendors', 'chunk-common', 'teacher' ]
    }
  },

  devServer: {
    proxy: {
      '^/api': {
        target: 'http://localhost:8080',
        changeOrigin: true
      }
    }
  }
}
