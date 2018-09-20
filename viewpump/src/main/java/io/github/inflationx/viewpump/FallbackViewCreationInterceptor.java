package io.github.inflationx.viewpump;

import android.view.View;

class FallbackViewCreationInterceptor implements io.github.inflationx.viewpump.Interceptor {

    @Override
    public io.github.inflationx.viewpump.InflateResult intercept(Chain chain) {
        io.github.inflationx.viewpump.InflateRequest request = chain.request();
        io.github.inflationx.viewpump.FallbackViewCreator viewCreator = request.fallbackViewCreator();
        View fallbackView = viewCreator.onCreateView(request.parent(), request.name(), request.context(), request.attrs());

        return io.github.inflationx.viewpump.InflateResult.builder()
                .view(fallbackView)
                .name(fallbackView != null ? fallbackView.getClass().getName() : request.name())
                .context(request.context())
                .attrs(request.attrs())
                .build();
    }
}
