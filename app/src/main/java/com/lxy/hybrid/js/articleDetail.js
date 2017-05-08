import React, {Component} from 'react';
import {
    AppRegistry,
    StyleSheet,
    Text,
    View,
    WebView,
    NativeModules
} from 'react-native';

export default class ArticleDetail extends Component {


    //准备加载组件
    componentWillMount(){
        console.log("index====detail====componentWillMount");

        this.test();

    }

    //在组件第一次绘制之后
    componentDidMount(){
        console.log("index====detail====componentDidMount");

    }

    render() {

        return <Text> detail </Text>


    }

}

AppRegistry.registerComponent('ArticleDetail', () => ArticleDetail);