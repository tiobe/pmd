---
title: PMD Release Notes
permalink: pmd_release_notes.html
keywords: changelog, release notes
---

## {{ site.pmd.date }} - {{ site.pmd.version }}

The PMD team is pleased to announce PMD {{ site.pmd.version }}.

This is a {{ site.pmd.release_type }} release.

{% tocmaker is_release_notes_processor %}

### New and noteworthy

#### New Rules

*   The new Java rule {% rule "java/bestpractices/UnusedAssignment" %} (`java-bestpractices`) finds assignments
    to variables, that are never used and are useless. The new rule is supposed to entirely replace
    {% rule "java/errorprone/DataflowAnomalyAnalysis" %}.

#### Modified rules

*   The Java rule {% rule "java/bestpractices/ArrayIsStoredDirectly" %} (`java-bestpractices`) now ignores
    by default private methods and constructors. You can restore the old behavior by setting the new property
    `allowPrivate` to "false".

### Fixed Issues

*   apex
    *   [#2610](https://github.com/pmd/pmd/pull/2610): \[apex] Support top-level enums in rules
*   apex-bestpractices
    *   [#2626](https://github.com/pmd/pmd/issues/2626): \[apex] UnusedLocalVariable - false positive on case insensitivity allowed in Apex
*   apex-performance
    *   [#2598](https://github.com/pmd/pmd/issues/2598): \[apex] AvoidSoqlInLoops false positive for SOQL with in For-Loop
*   apex-security
    *   [#2620](https://github.com/pmd/pmd/issues/2620): \[visualforce] False positive on VfUnescapeEl with new Message Channel feature
*   core
    *   [#710](https://github.com/pmd/pmd/issues/710): \[core] Review used dependencies
    *   [#2594](https://github.com/pmd/pmd/issues/2594): \[core] Update exec-maven-plugin and align it in all project
    *   [#2615](https://github.com/pmd/pmd/issues/2615): \[core] PMD/CPD produces invalid XML (insufficient escaping/wrong encoding)
*   java-bestpractices
    *   [#2543](https://github.com/pmd/pmd/issues/2543): \[java] UseCollectionIsEmpty can not detect the case this.foo.size()
    *   [#2569](https://github.com/pmd/pmd/issues/2569): \[java] LiteralsFirstInComparisons: False negative for methods returning Strings
    *   [#2622](https://github.com/pmd/pmd/issues/2622): \[java] ArrayIsStoredDirectly false positive with private constructor/methods
*   java-codestyle
    *   [#2546](https://github.com/pmd/pmd/issues/2546): \[java] DuplicateImports reported for the same import... and import static...
*   java-design
    *   [#2174](https://github.com/pmd/pmd/issues/2174): \[java] LawOfDemeter: False positive with 'this' pointer
    *   [#2181](https://github.com/pmd/pmd/issues/2181): \[java] LawOfDemeter: False positive with indexed array access
    *   [#2189](https://github.com/pmd/pmd/issues/2189): \[java] LawOfDemeter: False positive when casting to derived class
    *   [#2580](https://github.com/pmd/pmd/issues/2580): \[java] AvoidThrowingNullPointerException marks all NullPointerException objects as wrong, whether or not thrown
    *   [#2625](https://github.com/pmd/pmd/issues/2625): \[java] NPathComplexity can't handle switch expressions
*   java-errorprone
    *   [#2578](https://github.com/pmd/pmd/issues/2578): \[java] AvoidCallingFinalize detects some false positives
    *   [#2634](https://github.com/pmd/pmd/issues/2634): \[java] NullPointerException in rule ProperCloneImplementation
*   java-performance
    *   [#1736](https://github.com/pmd/pmd/issues/1736): \[java] UseStringBufferForStringAppends: False positive if only one concatenation
    *   [#2207](https://github.com/pmd/pmd/issues/2207): \[java] AvoidInstantiatingObjectsInLoops: False positive - should not flag objects when assigned to lists/arrays

### API Changes

#### Deprecated API

##### For removal

* {% jdoc core::lang.rule.RuleChainVisitor %} and all implementations in language modules
* {% jdoc core::lang.rule.AbstractRuleChainVisitor %}
* {% jdoc !!core::lang.Language#getRuleChainVisitorClass() %}
* {% jdoc !!core::lang.BaseLanguageModule#<init>(java.lang.String,java.lang.String,java.lang.String,java.lang.Class,java.lang.String...) %}
* {% jdoc core::lang.rule.ImportWrapper %}


### External Contributions
*   [#2558](https://github.com/pmd/pmd/pull/2558): \[java] Fix issue #1736 and issue #2207 - [Young Chan](https://github.com/YYoungC)
*   [#2560](https://github.com/pmd/pmd/pull/2560): \[java] Fix false positives of LawOfDemeter: this and cast expressions - [xioayuge](https://github.com/xioayuge)
*   [#2590](https://github.com/pmd/pmd/pull/2590): Update libraries snyk is referring to as `unsafe` - [Artem Krosheninnikov](https://github.com/KroArtem)
*   [#2597](https://github.com/pmd/pmd/pull/2597): \[dependencies] Fix issue #2594, update exec-maven-plugin everywhere - [Artem Krosheninnikov](https://github.com/KroArtem)
*   [#2621](https://github.com/pmd/pmd/pull/2621): \[visualforce] add new safe resource for VfUnescapeEl - [Peter Chittum](https://github.com/pchittum)
*   [#2640](https://github.com/pmd/pmd/pull/2640): \[java] NullPointerException in rule ProperCloneImplementation - [Mykhailo Palahuta](https://github.com/Drofff)
*   [#2641](https://github.com/pmd/pmd/pull/2641): \[java] AvoidThrowingNullPointerException marks all NullPointerException… - [Mykhailo Palahuta](https://github.com/Drofff)
*   [#2643](https://github.com/pmd/pmd/pull/2643): \[java] AvoidCallingFinalize detects some false positives (2578) - [Mykhailo Palahuta](https://github.com/Drofff)
*   [#2651](https://github.com/pmd/pmd/pull/2651): \[java] False negative: LiteralsFirstInComparisons for methods... (2569) - [Mykhailo Palahuta](https://github.com/Drofff)
*   [#2652](https://github.com/pmd/pmd/pull/2652): \[java] UseCollectionIsEmpty can not detect the case this.foo.size() - [Mykhailo Palahuta](https://github.com/Drofff)

### Stats
* 156 commits
* 43 closed tickets & PRs
* Days since last release: 28

{% endtocmaker %}

