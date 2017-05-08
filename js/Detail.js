import React, {Component} from 'react';
import {
    AppRegistry,
    StyleSheet,
    Text,
    View,
    WebView,
    NativeModules
} from 'react-native';


export default class Detail extends Component {

    constructor(props) {
            super(props)

            this.state = {
                page:'',
                loadSuccess: false,
            }
    }

    //准备加载组件
    componentWillMount(){
        console.log("index====detail====componentWillMount");

    }

    render() {

        return(<Text>detail</Text>);

    }

}

AppRegistry.registerComponent('Detail', () => Detail);