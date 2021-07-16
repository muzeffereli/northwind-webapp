import React from 'react';
import { useSelector } from 'react-redux';
import { NavLink } from 'react-router-dom';
import {Dropdown,Label} from 'semantic-ui-react';

export default function CartSummary() {
  
  const {cartItems} = useSelector(state => state.cart)
  return (
    <div>
      <Dropdown item text='Your Cart'>
        <Dropdown.Menu>
          {
            cartItems.map((cartItem)=>(
                
              <Dropdown.Item>
                {cartItem.product.productName}
                <Label>
                  {cartItem.quantity}
                </Label>
              </Dropdown.Item>
          
            ))
          }
          <Dropdown.Divider/>
          <Dropdown.Item as={NavLink} to="/cart">Go to cart</Dropdown.Item>
        </Dropdown.Menu>
      </Dropdown>
    </div>
  );
}