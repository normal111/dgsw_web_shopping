import React, {Component} from 'react';
import {inject, observer} from "mobx-react";
import ProductItem from "../Product/ProductItem";

import './Category.scss'

@inject('stores')
@observer
class Category extends Component {
    state = {
        products: []
    };

    async componentDidMount() {
        let category_id = this.props.match.params.category_id;
        let temp = await this.props.stores.ProductStore.getCategoryProduct(category_id);
        if (temp.length > 0) {
            // TODO:여기서 이상한 경고걸림 아마 값이 없어서 nullPoint일듯
            this.setState({
                products: temp
            });
        }
    }

    render() {
        this.componentDidMount();
        return (
            <div className='category-product-container'>
                <div className='category-product-text'>
                    카테고리 보기
                </div>
                <br/>
                <div className='category-product-items'>
                    {
                        this.state.products.map(item => <ProductItem product_id={item.id} key={item.id}/>)
                    }
                </div>
            </div>
        );
    }
}

export default Category;