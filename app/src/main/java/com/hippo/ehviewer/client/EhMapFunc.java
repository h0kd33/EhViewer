/*
 * Copyright 2017 Hippo Seven
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hippo.ehviewer.client;

/*
 * Created by Hippo on 1/19/2017.
 */

import retrofit2.adapter.rxjava.Result;
import rx.functions.Func1;

public abstract class EhMapFunc<T extends EhResult, R extends EhResult>
    implements Func1<Result<T>, Result<R>> {

  @Override
  public Result<R> call(Result<T> result) {
    return EhReactiveX.handleResult(result, this::onCall);
  }

  public abstract Result<R> onCall(T t);
}