
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
    render() {
        return (
            /*<WebView
                ref="webview"
                source={{uri:"http://www.baidu.com"}}
                automaticallyAdjustContentInsets={false}
                decelerationRate="normal"
                javaScriptEnabled={true}
                domStorageEnabled={true}
                scalesPageToFit={false}
                startInLoadingState={true}
            />*/

            <Text style={{height:100,width:100,backgroundColor:"#39c6c1"}} onPress={()=>{this.show()}}>去原生界面瞅瞅</Text>
        );
    }

    show(){
        //NativeModules.CustomToast.showToast("js调用原生toast消息",1);
        //NativeModules.CustomToast.pageJump();
        //NativeModules.IntentMoudle.startActivityFromJs("com.lxy.hybrid.NativeActivity","传递过去的参数");
        NativeModules.IntentMoudle.startActivityFromJsGetResult("com.lxy.hybrid.NativeActivity",200,
        (msg)=>{NativeModules.CustomToast.showToast("返回的数据为: "+msg,1)},
        (error)=>{NativeModules.CustomToast.showToast("错误信息为: "+error,1)});
    }

}

AppRegistry.registerComponent('gank', () => gank);
