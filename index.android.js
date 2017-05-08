import React, {Component} from 'react';
import {
    AppRegistry,
    StyleSheet,
    Text,
    View,
    WebView,
    NativeModules
} from 'react-native';



export default class gank extends Component {


    constructor(props) {
            super(props)

            this.state = {
                page:'',
                loadSuccess: false,
            }
    }

    //准备加载组件
    componentWillMount(){
        console.log("index========componentWillMount");

        this.test();

    }
    
    //在组件第一次绘制之后
    componentDidMount(){
        //console.log("index========componentDidMount");

    }

    render() {

        console.log("index========render");

        if(this.state.page=="page1"){
            //console.log("index========loadSuccess");
            return(<Text>page1</Text>);
        }else if(this.state.page=="page2"){
            //console.log("index========loadfail");
            return(<Text>page2</Text>);
        }else{
            return null;
        }

       /*

        //异步回调
         NativeModules.ValueUtil.getValueFromNative((msg)=>{

                                    value = msg;
                                    //NativeModules.CustomToast.showToast(value,1);

                                },
                                (msg)=>{
                                   // NativeModules.CustomToast.showToast(value,1);

                        });

         //promise
        //this.test();

*/
    }

    show(){
        //NativeModules.CustomToast.showToast("js调用原生toast消息",1);
        //NativeModules.CustomToast.pageJump();
        //NativeModules.IntentMoudle.startActivityFromJs("com.lxy.hybrid.NativeActivity","传递过去的参数");
        NativeModules.IntentMoudle.startActivityFromJsGetResult("com.lxy.hybrid.NativeActivity",200,
        (msg)=>{NativeModules.CustomToast.showToast("返回的数据为: "+msg,1)},
        (error)=>{NativeModules.CustomToast.showToast("错误信息为: "+error,1)});
    }

    showData(){
        NativeModules.ValueUtil.getValueFromNative((msg)=>{

                    NativeModules.CustomToast.showToast(msg,1);

                },
                (msg)=>{
                    NativeModules.CustomToast.showToast(msg,1);

        });
    }

    //测试发现此方法并未异步执行
    async test() {
      try {

        page = await NativeModules.ValueUtil.getValueFromNativePromise();

        //NativeModules.CustomToast.showToast(this.state.page+"",1);

        console.log("index========test==="+this.state.page);
        this.setState({
                            loadSuccess: true,
                            page:page,
        })


      } catch (e) {
        console.error(e);
      }
    }


}

AppRegistry.registerComponent('gank', () => gank);