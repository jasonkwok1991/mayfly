import request from './request'

export default {
    save: (param: any) => request.request('POST', '/image/saveImage', param, null),
    searchImage: () => request.request('get', '/image/searchImage', null, null),
}