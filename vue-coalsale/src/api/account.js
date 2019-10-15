import request from '@/plugins/request';

export function AccountLogin (data) {
    return request({
        url: '/api/logincs',
        method: 'post',
        data
    });
}

export function AccountRegister (data) {
    return request({
        url: '/api/registercs',
        method: 'post',
        data
    });
}
