'use strict';

const pageConfig = require('../src/PageConfig.js');

const fs = require('fs');
const JSZip = require('jszip');
const commander = require('commander');

//获取参数
commander
  .version('0.0.1')
  .description('a test cli program')
  .option('-o, --os <os>', 'your os', '0')
  .option('-s, --sign <sign>', 'your sign', 'debug')
  .option('-p, --page_name <page_name>', 'your page_name', 'Main_Mall')
  .option('-c, --count <count>', 'zip count', '1');


let args = commander.parse(process.argv);
console.log('解析结果 ==>' + JSON.stringify(args, null, 4));

/**
 * 获取命令参数
 * */
let divider = '=============================================';
let os = args.os;
let sign = args.sign;
let page_name = args.page_name;
let count = args.count;

console.log(divider);
console.log('当前系统 ==>' + os);
// console.log('==>' + sign);
console.log('页面名称==>' + page_name);
console.log('打包次数==>' + count);
console.log(divider);

let config = pageConfig[page_name];
for (let i = 0; i < count; i++) {
  let resultConfig = {};
  Object.assign(resultConfig, config);
  console.log(resultConfig.rn_version_code);
  generateBundleZip(resultConfig);
  config.rn_version_code++;
  console.log(resultConfig.rn_version_code);
}


// 打zip方法
function generateBundleZip(config) {

  console.log('配置信息==>' + JSON.stringify(config));
  console.log(divider);
  /**
   * 声明字段
   * */
  let zip = new JSZip();
  let dirPath = './bundle/' + os + '/';
  let config_name = config.page_name + '.json';
// todo 目前系统读取的名称的写死的
  config_name = 'index_config.json';
  let bundle_name = config.page_name + '.jsbundle';
  let zip_name = config.page_name + '_' + os + '_' + sign + '_' + config.rn_version_code + '.zip';

  console.log('bundle目录===>' + dirPath);
  console.log('config名称===>' + config_name);
  console.log('bundle名称===>' + bundle_name);
  console.log('压缩文件名称===>' + zip_name);

  config.os = os;
  if ('android' === os) {
    delete config.ios_app_version;
    delete config.ios_os_version;
    config.os = 0;
  } else if ('ios' === os) {
    delete config.android_app_version;
    delete config.android_os_version;
    config.os = 1;
  }

  console.log('bundle更目录', dirPath);
  fs.exists(dirPath, (exists) => {
    console.log(dirPath + '：' + exists);
    if (!exists) {
      mkdirSync(dirPath, function () {
        console.log(dirPath + '创建成功');
      })
    }
  });

  /**
   *
   * */
  fs.readFile(dirPath + bundle_name, function (err, data) {
    if (err) {
      console.log('请先打出应对的bundle文件');
      throw err;
    }
    console.log('读jsbundle成功');
    zip.file(bundle_name, data);
    zip.file(config_name, JSON.stringify(config, null, 4));
    zip.generateNodeStream({type: 'nodebuffer', streamFiles: true})
      .pipe(fs.createWriteStream(dirPath + zip_name))
      .on('finish', function () {
        // JSZip generates a readable stream with a "end" event,
        // but is piped here in a writable stream which emits a "finish" event.
        console.log(zip_name + ' written.');
      });
  });
}


/**
 * 创建文件
 * */
function mkdirSync(dir, cb) {
  let paths = dir.split('/');
  let index = 1;

  function next(index) {
    //递归结束判断
    if (index > paths.length) return cb();
    let newPath = paths.slice(0, index).join('/');
    fs.access(newPath, function (err) {
      if (err) {//如果文件不存在，就创建这个文件
        fs.mkdir(newPath, function (err) {
          next(index + 1);
        });
      } else {
        //如果这个文件已经存在，就进入下一个循环
        next(index + 1);
      }
    })
  }

  next(index);
}

