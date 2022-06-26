const { defineConfig } = require('@vue/cli-service');
const path = require('path');
module.exports = defineConfig({
	transpileDependencies: true,
	outputDir: path.resolve(__dirname, '../backend/src/main/resources/static'),
	// indexPath: path.resolve(__dirname, '../src/main/resources/static/index.html'),
	devServer: {
		client: {
			overlay: false,
		},
	},
});
