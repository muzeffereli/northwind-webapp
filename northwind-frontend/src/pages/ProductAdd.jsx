import { Form, Formik } from 'formik';
import React from 'react';
import * as Yup from 'yup';
import { Button } from 'semantic-ui-react';
import CustomTextInput from '../utilities/customFormControls/CustomTextInput';
import axios from 'axios';

export default function ProductAdd() {
  const initialValues = { productName: '', unitPrice: 10 };

  const schema = Yup.object({
    productName: Yup.string().required('Product name must be entered.'),
    unitPrice: Yup.number().required('Product price must be entered.'),
  });

  return (
    <div>
      <Formik
        initialValues={initialValues}
        validationSchema={schema}
        onSubmit={(values) => {
            axios.post("http://localhost:8080/api/products/add",values)
        }}
      >
        <Form className='ui form'>
          <CustomTextInput name='productName' placeholder='Product Name' />
          <CustomTextInput name='unitPrice' placeholder='Product Price' />
          <Button color='green' type='submit'>
            Add Product
          </Button>
        </Form>
      </Formik>
    </div>
  );
}

/* <FormField>
            <Field name='productName' placeholder='Product Name'></Field>
            <ErrorMessage name="productName" render={error=>
                <Label pointing basic color="red" content={error}></Label>
            }></ErrorMessage>
          </FormField>
          <FormField>
            <Field name='unitPrice' placeholder='Product Price'></Field>
            <ErrorMessage name="unitPrice" render={error=>
                <Label pointing basic color="red" content={error}></Label>
            }></ErrorMessage>
          </FormField> 
          
*/
