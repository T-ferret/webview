const path = require('path')

module.exports = {
    entry: './src/main/js/app.js',    // 진입점 파일
    output: {
        filename: 'bundle.js',
        path: path.resolve(__dirname, 'src/main/resources/static/js'),
    },
    mode: 'development',
    module: {
        rules: [
            {
                test: /\.js$/,
                exclude: /node_modules/,
                use: {
                    loader: 'babel-loader',
                    options: {
                        presets: ['@babel/preset-env']
                    }
                }
            }
        ]
    }
    // resolve: {
    //     modules: ['node_modules'],  // Resolve modules from node_modules directory
    //     extensions: ['.js'] //Resolve .js files
    // }
};