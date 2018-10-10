import { shallowMount } from '@vue/test-utils';
import Users from '@/components/Users'

describe('Users.vue', () => {
  it('should render loading message', () => {
    const wrapper = shallowMount(User);
    const contentButton = wrapper.find('loading');
    expect(contentButton.text()).toEqual('Loading...');
  })
})
