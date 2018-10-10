import { shallowMount } from '@vue/test-utils';
import Hello from '@/components/Hello'

describe('Hello.vue', () => {
  it('should render correct hello message', () => {
    const hellowrapped = shallowMount(Hello, {
      stubs: ['router-link', 'router-view']
    });

    const contentH1 = hellowrapped.find('h1');

    expect(contentH1.text()).toEqual('NLA');
  })
})
