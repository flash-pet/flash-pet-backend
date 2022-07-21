package com.senac.adapter.repository.param;

import java.util.Map;

public interface Parameter<O> {
        O build(Map<String, Object> params);
}
