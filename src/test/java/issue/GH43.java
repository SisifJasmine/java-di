package issue;

/*-
 * #%L
 * OSGL Genie
 * %%
 * Copyright (C) 2016 - 2018 OSGL (Open Source General Library)
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import org.junit.Test;
import org.osgl.$;
import org.osgl.inject.BeanSpec;
import org.osgl.inject.Genie;
import org.osgl.util.Generics;
import osgl.ut.TestBase;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import javax.inject.Named;

public class GH43 extends TestBase {

    public static abstract class Foo<ID_TYPE> {
        public void doIt(@Named("foo") List<ID_TYPE> id) {}
    }

    public static class IntFoo extends Foo<Integer> {
    }

    @Test
    public void test() {
        Genie genie = Genie.create();
        Method method = $.getMethod(Foo.class, "doIt", List.class);
        Map<String, Class> typeVarLookup = Generics.buildTypeParamImplLookup(IntFoo.class);
        Type type = method.getGenericParameterTypes()[0];
        Annotation[] anno = method.getParameterAnnotations()[0];
        BeanSpec spec = BeanSpec.of(type, anno, genie, typeVarLookup);
    }

}