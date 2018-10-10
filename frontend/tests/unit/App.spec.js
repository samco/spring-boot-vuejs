import { shallowMount, createLocalVue } from '@vue/test-utils';
import App from '@/App';

describe('App component should', () => {
  it('render without crashing', () => {
    const wrapper = shallowMount(App, {
      stubs: ['router-link', 'router-view']
    });
    expect(wrapper.find('hello')).toBeDefined();
  });
});
