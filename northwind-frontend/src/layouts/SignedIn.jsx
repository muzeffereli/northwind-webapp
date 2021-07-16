import React from 'react';
import { Dropdown, Menu,Image } from 'semantic-ui-react';

export default function SignedIn({signOut}) {
  return (
    <div>
      <Menu.Item>
        <Image
          avatar
          spaced='right'
          src='https://secure.gravatar.com/avatar/d6fd6bff19d7f0ad4024f3811474fe92?s=180&d=mm&r=g'
        />
        <Dropdown pointing="top left" text="Muzaffer">
          <Dropdown.Menu>
            <Dropdown.Item text='Info' icon='info' />
            <Dropdown.Item onClick = {signOut} text='Sign out' icon='sign-out' />
          </Dropdown.Menu>
        </Dropdown>
      </Menu.Item>
    </div>
  );
}
