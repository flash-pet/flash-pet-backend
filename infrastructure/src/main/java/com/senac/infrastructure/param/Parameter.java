package com.senac.infrastructure.param;

import java.util.Map;

public interface Parameter<O> {
        O build(Map<String, String> params);
}
