
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
        NativeModules.CustomToast.showToast("js调用原生toast消息",1);
        NativeModules.CustomToast.pageJump();
    }

}

AppRegistry.registerComponent('gank', () => gank);
