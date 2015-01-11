ScalaCheck のお話
=================

http://ngo-java.connpass.com/event/10985/

なごやかJava ゆるふわテストツール編の資料です。

ScalaCheck とは
---------------

ある入力の集合からランダムに値を生成し、テストを行う (Random testing) ライブラリ。
もしくは、対象の性質を記述してランダムに値を生成してテストする、Property-based testing ライブラリ。

pocketberserker としては性質ばかり書いているわけでもないので、主に Random testing のほうを主張する。

scalacheck は Haskell の QuickCheck に影響を受けている。

コード例
--------

src/test/scala/nagoyaka/QuickStart.scala

src/test/scala/nagoyaka/FizzBuzzSpec.scala

よくあるテスト例
----------------

* データの可逆変換
* 既存(競合)ライブラリとの互換性テスト
* ある集合の関数適用が期待値に一致するか

段階を経る
----------

いきなり性質を考えるのはつらいことが多いので、段階を踏んでみましょう。

1. 入力と出力の集合の mapping を考える
1. (JUnit, scalatest, specs2 などで) テストを書く
1. そのうち parameterized test するコードが出現する
1. ランダムテストに書き直す

利点
----

* 性質をコードで表現できる
* 運が良ければエッジケースを見つけられる
* (証明の足掛かりになるかも?)

欠点
----

* 何を書けばよいかわからないことがある
* ランダムデータ生成コードの実装がつらい
* あくまでランダムなので、何回も実行しないと失敗しない可能性がある
* テスト実行速度が遅くなる可能性がある

Java プロジェクトで ScalaCheck を利用している実例
-------------------------------------------------

* https://github.com/msgpack/msgpack-java
* https://github.com/xuwei-k/free-monad-java/tree/develop

