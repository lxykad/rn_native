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
                url: '',
                page:''
            }
    }


    //准备加载组件
    componentWillMount(){
        console.log("index========componentWillMount");

        this.test();

    }

    //在组件第一次绘制之后
    componentDidMount(){
        console.log("index========componentDidMount");

    }



    render() {

        var value = "";


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



        console.log("index========render===="+this.state.page);

         if("page1"== this.state.page){
            NativeModules.CustomToast.showToast("11111",1);

            return (

                                           <Text style={{height: 100, width: 100, backgroundColor: "#39c6c1"}} onPress={() => {
                                               this.showData()
                                           }}>page1</Text>
                                       );

         }else if("page2"== this.state.page){
            NativeModules.CustomToast.showToast(value,1);
            return (

                                           <Text style={{height: 100, width: 100, backgroundColor: "#39c6c1"}} onPress={() => {
                                               this.showData()
                                           }}>page2</Text>
                                       );

         }else{

          return (

                                        <Text style={{height: 100, width: 100, backgroundColor: "#39c6c1"}} onPress={() => {
                                            this.showData()
                                        }}>默认</Text>
                                    );

         }

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

        this.state.page = await NativeModules.ValueUtil.getValueFromNativePromise();

        NativeModules.CustomToast.showToast(this.state.page+"",1);

        console.log("index========test==="+this.state.page);


      } catch (e) {
        console.error(e);
      }
    }

}

AppRegistry.registerComponent('gank', () => gank);