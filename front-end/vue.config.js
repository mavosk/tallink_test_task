module.exports = {
    devServer: {
        proxy: {
            'http://localhost:8080': {
                target: 'http://localhost:8090/allRooms',
                ws: true,
                changeOrigin: true
            }
        }
    }
};
