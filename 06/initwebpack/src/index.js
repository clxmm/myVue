import $ from 'jquery'
import './css/1.css'
import './css/1.less'
import './css/1.scss'

// import App from './components/App.vue'

$(function() {
    $('li:odd').css('backgroundColor','pink');
    $('li:even').css('backgroundColor','red');


})

class Persion {
    static info = 'aaa';
}

console.log(Persion.info)



//  vue 的
import Vue from 'vue'

//导入单文件组件
import App from './components/App.vue'

const vm = new Vue({
    // 3. 指定 vm 实例要控制的页面区域
    el: 'app11',
    // 4. 通过 render 函数，把指定的组件渲染到 el 区域中
    render: h => h(App)
})