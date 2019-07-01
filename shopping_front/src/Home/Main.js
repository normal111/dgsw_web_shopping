import React, {Component} from 'react';
import {inject, observer} from "mobx-react";
import {Redirect} from 'react-router-dom';

import './Main.scss';

@inject('stores')
@observer
class Main extends Component {
    state = {
        product_id: null
    };

    async componentDidMount() {
        let product_id = this.props.product_id;
        await this.props.stores.ProductStore.setProduct(product_id);
        this.setState({
            product_id: product_id
        });
    }

    render() {
        if (this.state.gotoCart) {
            return <Redirect to='/cart'/>;
        }

        let p = this.props.stores.ProductStore.current_product;

        if (p === null)
            return <div/>;

        let imageSrc = `http://localhost:8080/download/product/${this.state.product_id}`;

        return (
            <div className='main-image-container'>
                <img className='main-image' src={imageSrc} alt="메인 이미지"/>
            </div>
        );
    }
}

export default Main;