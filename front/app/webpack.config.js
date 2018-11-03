const webpack = require('webpack');

module.exports = env => {

    console.dir(env);
    console.dir(__dirname);

    return {
        entry: './app.js',
        output: {
            path: __dirname + '/out',
            filename: 'app.bundle.js'
        },
        mode: 'development',
        module: {
            rules: [{
                test: /\.js$/,
                exclude: [/node_modules/, /bin/],
                use: 'babel-loader',
            }, {
                test: /\.css$/,
                include(filepath) {
                    if (filepath.includes('react-s-alert')) return true;
                    return false;
                },
                use: [{loader: "style-loader"},
                    {loader: "css-loader"},
                    {loader: "postcss-loader"}]
            }, {
                test: /\.less$/,
                exclude: [/node_modules/, /bin/],
                use: [{loader: "style-loader"},
                    {loader: "css-loader"},
                    {loader: "postcss-loader"},
                    {loader: "less-loader"}]
            }, {
                test: /\.png$/,
                exclude: [/node_modules/, /bin/],
                use: [{
                    loader: "url-loader",
                    options: {
                        "limit": 1000000,
                        "mimetype": "image/png"
                    }
                }]
            }, {
                test: /\.jsx$/,
                exclude: [/node_modules/, /bin/],
                use: "babel-loader"
            }, {
                test: /\.svg$/,
                use: [
                    {
                        loader: 'babel-loader',
                        options: {
                            presets: ['es2015', 'react']
                        }
                    },
                    {
                        loader: 'react-svg-loader',
                        // options: {
                        //     svgo: {
                        //         plugins: [{removeTitle: false}],
                        //         floatPrecision: 2
                        //     }
                        // }
                    }
                ]
            }]
        },
        plugins: [
            new webpack.DefinePlugin({
                'process.env': {
                    'FOTO_CATALOG': JSON.stringify(env.FOTO_CATALOG),
                    'TEMP_CATALOG': JSON.stringify(env.TEMP_CATALOG)
                }
            })
        ],

        resolve: {
            extensions: ['.js', '.jsx']
        },

        devtool: "source-map"
    }
}
