import React, {Component} from 'react';
import {inject, observer} from "mobx-react";
import {Link} from 'react-router-dom';

import './SimpleProduct.scss'

@inject('stores')
@observer
class SimpleProduct extends Component {
    state = {
        id: null,
        name: null,
        price: null,
        image: null,
        company: null,
        category_id: null,
        sub_category: null,
        mileage: null,
        content: null,
        detail: null,
        pur_info: null
    };

    async componentDidMount() {
        if (this.props.product_id != null) {
            let product = await this.props.stores.ProductStore.getProduct(this.props.product_id);
            this.setState({
                ...this.state,
                id: product.id,
                name: product.name,
                price: product.price,
                image: product.image,
                company: product.company,
                category_id: product.category_id,
                sub_category: product.sub_category,
                mileage: product.mileage,
                content: product.content,
                detail: product.detail,
                pur_info: product.pur_info
            });
        }
    }

    render() {
        if (this.state.id === null)
            return <div/>;

        let productLink = `/product/${this.state.id}`;
        let imageSrc = `http://localhost:8080/download/product/${this.state.id}`;
        return (
            <div className='sim-product-item'>
                <Link to={productLink}>
                    <img  className='sim-product-image' src={imageSrc} alt="제품이미지"/>
                    <div className='sim-product-name'>{this.state.name}</div>
                    <div className='sim-product-price'>{this.state.price}</div>
                </Link>
            </div>
        );
    }
}

export default SimpleProduct;