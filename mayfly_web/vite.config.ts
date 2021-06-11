import vue from '@vitejs/plugin-vue';
import { resolve } from 'path';
import type { UserConfig } from 'vite';
import { loadEnv } from './src/common/utils/viteBuild.ts';

const pathResolve = (dir: string): any => {
	return resolve(__dirname, '.', dir);
};

const { VITE_PORT, VITE_OPEN, VITE_PUBLIC_PATH } = loadEnv();

const alias: Record<string, string> = {
	'@': pathResolve('src/'),
};

const viteConfig: UserConfig = {
	plugins: [vue()],
	root: process.cwd(),
	resolve: { alias },
	base: process.env.NODE_ENV === 'production' ? VITE_PUBLIC_PATH : './',
	optimizeDeps: {
		include: ['element-plus/lib/locale/lang/zh-cn'],
	},
	server: {
		host: '0.0.0.0',
		port: VITE_PORT,
		open: VITE_OPEN,
		proxy: {
			'/api': {
				target: 'localhost:8888',
				ws: true,
				changeOrigin: true,
				// rewrite: (path) => path.replace(/^\/api/, ''),
			},
		},
	},
	build: {
		outDir: 'dist',
		minify: 'esbuild',
		sourcemap: false,
	},
	define: {
		__VUE_I18N_LEGACY_API__: JSON.stringify(false),
		__VUE_I18N_FULL_INSTALL__: JSON.stringify(false),
		__INTLIFY_PROD_DEVTOOLS__: JSON.stringify(false),
	},
};

export default viteConfig;
